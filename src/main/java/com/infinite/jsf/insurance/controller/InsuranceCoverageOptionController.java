package com.infinite.jsf.insurance.controller;
 
import java.io.Serializable;
import java.util.List;
 
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
 
import com.infinite.jsf.insurance.dao.InsuranceCoverageOptionDao;
import com.infinite.jsf.insurance.daoImpl.InsuranceCoverageOptionDaoImpl;
import com.infinite.jsf.insurance.model.InsuranceCoverageOption;
import com.infinite.jsf.insurance.model.InsurancePlan;
 
import lombok.Data;
 
@Data
public class InsuranceCoverageOptionController implements Serializable {
 
    private static final long serialVersionUID = 1L;
 
    private InsuranceCoverageOption coverageOption = new InsuranceCoverageOption();
    private InsurancePlan insurancePlan = new InsurancePlan();
 
    private InsuranceCoverageOptionDao coverageOptionDao = new InsuranceCoverageOptionDaoImpl();
 
    private List<InsuranceCoverageOption> coverageOptionsType;
    private List<InsuranceCoverageOption> allCoverageOptions;
 
    // ========== Business Methods ==========
 
    public String saveCoverageOption() {
        // Set insurance plan before saving
        coverageOption.setInsurancePlan(insurancePlan);
 
        if (validateInsuranceCoverageOptionWithFacesMessage(coverageOption)) {
            coverageOptionDao.addInsuranceCoverageOption(coverageOption);
            FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Coverage Option added successfully!", null));
            coverageOption = new InsuranceCoverageOption(); // Reset
            return "showInsuranceCoverageOption?faces-redirect=true";
        }
        return null;
    }
 
    public List<InsuranceCoverageOption> findAllCoverageOptions() {
        if (allCoverageOptions == null) {
            allCoverageOptions = coverageOptionDao.findAllCoverageOption();
        }
        return allCoverageOptions;
    }
 
    public String deleteCoverageOption(String coverageId) {
        String result = coverageOptionDao.deleteInsuranceCoverageOption(coverageId);
        if ("deleted".equals(result)) {
            FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Coverage Option deleted successfully!", null));
            allCoverageOptions = null; // Refresh
        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Coverage Option not found!", null));
        }
        return null;
    }
 
    public String searchByPlanType(String planType) {
        coverageOptionsType = coverageOptionDao.searchByPlanType(planType);
        return "showcoverageplanbyplantype?faces-redirect=true";
    }
 
    public String searchStatus(InsuranceCoverageOption cov) {
        this.coverageOption = cov;
        FacesContext.getCurrentInstance()
                .getExternalContext()
                .getSessionMap()
                .put("selectedCoverage", cov);
        return "searchcoveragedetails?faces-redirect=true";
    }
 
    public String getCoverageDetail() {
        this.coverageOption = (InsuranceCoverageOption) FacesContext.getCurrentInstance()
                .getExternalContext()
                .getSessionMap()
                .get("selectedCoverage");
        return "searchcoveragedetails";
    }
 
    // ========== Validation Method ==========
 
    public boolean validateInsuranceCoverageOptionWithFacesMessage(InsuranceCoverageOption option) {
        FacesContext context = FacesContext.getCurrentInstance();
        boolean isValid = true;
 
        // Coverage ID
        if (option.getCoverageId() == null || option.getCoverageId().trim().isEmpty()) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Coverage ID is required.", null));
            isValid = false;
        } else if (!option.getCoverageId().toUpperCase().matches("^COV\\d{3}$")) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                "Coverage ID must be in format 'COV###', e.g., COV001.", null));
            isValid = false;
        }
 
        // Plan
        if (option.getInsurancePlan() == null || option.getInsurancePlan().getPlanId() == null) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                "Associated Insurance Plan is required.", null));
            isValid = false;
        }
 
        // Premium Amount
        if (option.getPremiumAmount() < 500 || option.getPremiumAmount() > 100000) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                "Premium must be between ₹500 and ₹100000.", null));
            isValid = false;
        }
 
        // Coverage Amount
        if (option.getCoverageAmount() < 100000 || option.getCoverageAmount() > 50000000) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                "Coverage must be between ₹1,00,000 and ₹5,00,00,000.", null));
            isValid = false;
        }
 
        // Status
        if (option.getStatus() == null || option.getStatus().trim().isEmpty()) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Status is required.", null));
            isValid = false;
        }
 
        return isValid;
    }
}