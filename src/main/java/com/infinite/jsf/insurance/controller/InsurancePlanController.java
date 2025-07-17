//package com.infinite.jsf.insurance.controller;
//
//import java.util.Date;
//import java.util.List;
//
//import javax.faces.application.FacesMessage;
//import javax.faces.context.FacesContext;
//
//import com.infinite.jsf.insurance.dao.InsurancePlanDao;
//import com.infinite.jsf.insurance.daoImpl.InsurancePlanDaoImpl;
//import com.infinite.jsf.insurance.model.InsuranceCompany;
//import com.infinite.jsf.insurance.model.InsurancePlan;
//
//import lombok.Data;
//
//@Data
//public class InsurancePlanController {
//
//	private InsurancePlan insurancePlan;
//	private InsuranceCompany insuranceCompany;
//    private String showSuccessMessage ;
//	private InsurancePlanDao plandao = new InsurancePlanDaoImpl();
//	
//	
//	
//	static {
//		
//	}
//	
////	=============methods==============
//
//	public List<InsurancePlan> findAllPlan() {
//		return plandao.showAllPlans();
//	}
//
//	public String addPlan(InsurancePlan insurancePlan) {
//		
//		insurancePlan.setInsuranceCompany(insuranceCompany);
//		if(validateInsurancePlanWithFacesMessage(insurancePlan)) {
//
//			plandao.addInsurancePlan(insurancePlan);
//
//			return "showplan?faces-redirect=true";
//			
//		}
//		
//		return null;
//
//
//	}  
//	public String searchPlanById(String planId) {
//		
//		FacesContext context=FacesContext.getCurrentInstance();
//		insurancePlan= plandao.searchInsurancePlanById(planId); 
//		System.out.println("=====search method is called==========");
//		System.out.println(insurancePlan);
//		
//		context.getExternalContext().getSessionMap().put("planId", planId);
//		
//		if(insurancePlan==null) {
//			context.addMessage(null,new FacesMessage("plan is not found with this id : "+planId ,null));
//			return null;	
//		}
//		
//		return "searchPlanById?faces-redirect=true";
//		
//	}
//	
//	public String deletePlaneById(String planId) {
//		FacesContext context=FacesContext.getCurrentInstance();
//		insurancePlan= plandao.searchInsurancePlanById(planId); 
//		if(insurancePlan==null) {
//			context.addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"plan is not found with this id : "+planId ,null));
//			return null;	
//		}
//		
//		plandao.deleteInsurancePlan(insurancePlan);
//		
//		showSuccessMessage = "plan deleted showsuccessfully!";
//
//
//		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "company deleted succussfully!", null));
//
//		return "showplan?faces-redirect=true";
//	}
//	
//
//	
//  public String updateInsurancePlan(InsurancePlan plan) {
//	  FacesContext context=FacesContext.getCurrentInstance();
////	  String planId=(String) context.getExternalContext().getSessionMap().get("planId");
////	  plan.setPlanId(planId);
//	  System.out.println("=====update method is called==========");
//		System.out.println(plan);
//		
//	  if(validateInsurancePlanWithFacesMessage(plan)) {
//		  
//		  plandao.updateInsurancePlan(plan);
//		  return "showplan?faces-redirect=true";
//	  }
//	  
//	  
//	  
//	  context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"validation Fails",null));
//	  return null;
//  
//	  
//  }
//	public boolean validateInsurancePlanWithFacesMessage(InsurancePlan plan) {
//	    FacesContext context = FacesContext.getCurrentInstance();
//	    boolean isValid = true;
//
//	    
//
//	    // Plan Name
//	    if (plan.getPlanName() == null || plan.getPlanName().trim().isEmpty()) {
//	        context.addMessage("companyForm:planName", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Plan name is required.", null));
//	        isValid = false;
//	    } else if (plan.getPlanName().trim().length() < 4) {
//	        context.addMessage("companyForm:planName", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Plan name must be at least 4 characters.", null));
//	        isValid = false;
//	    }
//
//	    
//
//	    // Insurance Company
//	    if (plan.getInsuranceCompany() == null || plan.getInsuranceCompany().getCompanyId() == null) {
//	        context.addMessage("companyForm:companyId", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Insurance company is required.", null));
//	        isValid = false;
//	    }
//
//	    // Description
//	    if (plan.getDescription() == null || plan.getDescription().trim().isEmpty()) {
//	        context.addMessage("companyForm:description", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Description is required.", null));
//	        isValid = false;
//	    } else if (plan.getDescription().trim().length() <= 5) {
//	        context.addMessage("companyForm:description", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Description must be more than 5 characters.", null));
//	        isValid = false;
//	    }
//
//	    // Available Cover Amounts (assume it's a String, convert to double if needed)
//	    try {
//	        double coverAmount = Double.parseDouble(plan.getAvailableCoverAmounts().trim());
//	        if (coverAmount <= 0) {
//	            context.addMessage("companyForm:cover", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Cover amount must be positive.", null));
//	            isValid = false;
//	        }
//	    } catch (Exception e) {
//	        context.addMessage("companyForm:cover", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid cover amount.", null));
//	        isValid = false;
//	    }
//
//	    // Min Entry Age
//	    if (plan.getMinEntryAge() <= 0) {
//	        context.addMessage("companyForm:minAge", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Minimum age must be greater than 0.", null));
//	        isValid = false;
//	    }
//
//	    // Max Entry Age
//	    if (plan.getMaxEntryAge() <= 0 || plan.getMaxEntryAge() < plan.getMinEntryAge()) {
//	        context.addMessage("companyForm:maxAge", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Maximum age must be greater than minimum age.", null));
//	        isValid = false;
//	    }
//
//	    // Waiting Period (must be between 0 and 12)
//	    try {
//	        int waiting = Integer.parseInt(plan.getWaitingPeriod().trim());
//	        if (waiting < 0 || waiting > 12) {
//	            context.addMessage("companyForm:waitingPeriod", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Waiting period must be between 0 and 12 months.", null));
//	            isValid = false;
//	        }
//	    } catch (Exception e) {
//	        context.addMessage("companyForm:waitingPeriod", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid waiting period.", null));
//	        isValid = false;
//	    }
//
//	    // Periodic Diseases
//	    if (plan.getPeriodicDiseases() == null || plan.getPeriodicDiseases().trim().isEmpty()) {
//	        context.addMessage("companyForm:periodicDiseases", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Periodic diseases field is required.", null));
//	        isValid = false;
//	    }
//
//	    // Active On, Created On, Expire Date logic
//	    Date activeOn = plan.getActiveOn();
//	    Date createdOn = plan.getCreatedOn();
//	    Date expireDate = plan.getExpireDate();
//
//	    if (activeOn == null) {
//	        context.addMessage("companyForm:activeOn", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Active On date is required.", null));
//	        isValid = false;
//	    } else {
//	        if (createdOn != null && activeOn.before(createdOn)) {
//	            context.addMessage("companyForm:activeOn", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Active On date cannot be before Created On date.", null));
//	            isValid = false;
//	        }
//	        if (expireDate != null && activeOn.after(expireDate)) {
//	            context.addMessage("companyForm:activeOn", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Active On date cannot be after Expire date.", null));
//	            isValid = false;
//	        }
//	    }
//
//	    return isValid;
//	}
//
//	
//}


package com.infinite.jsf.insurance.controller;
 
import java.util.Date;
import java.util.List;
 
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
 
import com.infinite.jsf.insurance.dao.InsurancePlanDao;
import com.infinite.jsf.insurance.daoImpl.InsurancePlanDaoImpl;
import com.infinite.jsf.insurance.model.InsuranceCompany;
import com.infinite.jsf.insurance.model.InsurancePlan;
 
 
public class InsurancePlanController {
 
	private InsurancePlan insurancePlan;
	private InsuranceCompany insuranceCompany;
	private InsurancePlanDao plandao;
	private String showSuccessMessage;
	private List<InsurancePlan> planList;
	// Constructor
    public InsurancePlanController() {
        insurancePlan = new InsurancePlan();
        insuranceCompany = new InsuranceCompany();
        plandao = new InsurancePlanDaoImpl(); //This initializes the DAO
    }

	public List<InsurancePlan> getPlanList() {
	    if (planList == null) {
	        planList = plandao.showAllPlans(); // This method is already implemented and working
	    }
	    return planList;
	}
	
	//==============//=====//
	private String searchPolicyId;
	private String searchHid;
	private String searchDob;
	private List<InsurancePlan> searchResults;
	public String getSearchPolicyId() { return searchPolicyId; }
	public void setSearchPolicyId(String searchPolicyId) { this.searchPolicyId = searchPolicyId; }

	public String getSearchHid() { return searchHid; }
	public void setSearchHid(String searchHid) { this.searchHid = searchHid; }

	public String getSearchDob() { return searchDob; }
	public void setSearchDob(String searchDob) { this.searchDob = searchDob; }

	public List<InsurancePlan> getSearchResults() { return searchResults; }

	public String searchPlanByPolicyOrRecipient() {
	    searchResults = plandao.searchByPolicyIdOrRecipient(searchPolicyId, searchHid, searchDob);
	    if (searchResults == null || searchResults.isEmpty()) {
	        FacesContext.getCurrentInstance().addMessage(null,
	            new FacesMessage(FacesMessage.SEVERITY_WARN, "No plans found for the given criteria", null));
	    }
	    return null;
	}
	
	
	
	

    //======//
	 private String selectedType;
	    private List<InsurancePlan> filteredPlans;

	    InsurancePlanDao planDao = new InsurancePlanDaoImpl();

	    public String select(String type) {
	        this.selectedType = type.toUpperCase(); // e.g., "SELF"
	        this.filteredPlans = planDao.getPlansByType(this.selectedType);
	        return "NInsurancePlans";  // navigates to NInsurancePlans.jsp
	    }

	    public List<InsurancePlan> getFilteredPlans() {
	        return filteredPlans;
	    }

	    public void setFilteredPlans(List<InsurancePlan> filteredPlans) {
	        this.filteredPlans = filteredPlans;
	    }

	    public String getSelectedType() {
	        return selectedType;
	    }

	    public void setSelectedType(String selectedType) {
	        this.selectedType = selectedType;
	    }
		
	// ========== Show All ==========
	public List<InsurancePlan> findAllPlan() {
		return plandao.showAllPlans();
	}
 
	// ========== Add ==========
	public String addPlan() {
		insurancePlan.setInsuranceCompany(insuranceCompany);
		if (validateInsurancePlanWithFacesMessage(insurancePlan)) {
			plandao.addInsurancePlan(insurancePlan);
			showSuccessMessage = "Plan added successfully!";
			insurancePlan = new InsurancePlan(); // reset
			return "showplan?faces-redirect=true";
		}
		return null;
	}
 
	// ========== Search ==========
	public String searchPlanById(String planId) {
		FacesContext context = FacesContext.getCurrentInstance();
		insurancePlan = plandao.searchInsurancePlanById(planId);
		context.getExternalContext().getSessionMap().put("planId", planId);
 
		if (insurancePlan == null) {
			context.addMessage(null, new FacesMessage("Plan not found for ID: " + planId));
			return null;
		}
		return "NPlanDetails?faces-redirect=true";
	}
 
	// ========== Delete ==========
	public String deletePlaneById(String planId) {
		FacesContext context = FacesContext.getCurrentInstance();
		String result = plandao.deleteInsurancePlan(planId);
 
		if ("deleted".equals(result)) {
			showSuccessMessage = "Plan deleted successfully!";
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, showSuccessMessage, null));
			return "showplan?faces-redirect=true";
		} else {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Plan not found for ID: " + planId, null));
			return null;
		}
	}
 
	// ========== Update ==========
	public String updateInsurancePlan() {
		FacesContext context = FacesContext.getCurrentInstance();
		if (validateInsurancePlanWithFacesMessage(insurancePlan)) {
			plandao.updateInsurancePlan(insurancePlan);
			showSuccessMessage = "Plan updated successfully!";
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, showSuccessMessage, null));
			return "showplan?faces-redirect=true";
		}
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Validation failed", null));
		return null;
	}
 
	// ========== Validation ==========
	public boolean validateInsurancePlanWithFacesMessage(InsurancePlan plan) {
		FacesContext context = FacesContext.getCurrentInstance();
		boolean isValid = true;
 
		if (plan.getPlanName() == null || plan.getPlanName().trim().isEmpty()) {
			context.addMessage("companyForm:planName", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Plan name is required.", null));
			isValid = false;
		} else if (plan.getPlanName().trim().length() < 4) {
			context.addMessage("companyForm:planName", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Plan name must be at least 4 characters.", null));
			isValid = false;
		}
 
		if (plan.getInsuranceCompany() == null || plan.getInsuranceCompany().getCompanyId() == null) {
			context.addMessage("companyForm:companyId", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Insurance company is required.", null));
			isValid = false;
		}
 
		if (plan.getDescription() == null || plan.getDescription().trim().isEmpty()) {
			context.addMessage("companyForm:description", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Description is required.", null));
			isValid = false;
		} else if (plan.getDescription().trim().length() <= 5) {
			context.addMessage("companyForm:description", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Description must be more than 5 characters.", null));
			isValid = false;
		}
 
		try {
			double coverAmount = Double.parseDouble(plan.getAvailableCoverAmounts().trim());
			if (coverAmount <= 0) {
				context.addMessage("companyForm:cover", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Cover amount must be positive.", null));
				isValid = false;
			}
		} catch (Exception e) {
			context.addMessage("companyForm:cover", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid cover amount.", null));
			isValid = false;
		}
 
		if (plan.getMinEntryAge() <= 0) {
			context.addMessage("companyForm:minAge", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Minimum age must be > 0.", null));
			isValid = false;
		}
 
		if (plan.getMaxEntryAge() <= 0 || plan.getMaxEntryAge() < plan.getMinEntryAge()) {
			context.addMessage("companyForm:maxAge", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Maximum age must be greater than minimum age.", null));
			isValid = false;
		}
 
		try {
			int waiting = Integer.parseInt(plan.getWaitingPeriod().trim());
			if (waiting < 0 || waiting > 12) {
				context.addMessage("companyForm:waitingPeriod", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Waiting period must be between 0 and 12 months.", null));
				isValid = false;
			}
		} catch (Exception e) {
			context.addMessage("companyForm:waitingPeriod", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid waiting period.", null));
			isValid = false;
		}
 
		if (plan.getPeriodicDiseases() == null || plan.getPeriodicDiseases().trim().isEmpty()) {
			context.addMessage("companyForm:periodicDiseases", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Periodic diseases field is required.", null));
			isValid = false;
		}
 
		Date activeOn = plan.getActiveOn();
		Date createdOn = plan.getCreatedOn();
		Date expireDate = plan.getExpireDate();
 
		if (activeOn == null) {
			context.addMessage("companyForm:activeOn", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Active On date is required.", null));
			isValid = false;
		} else {
			if (createdOn != null && activeOn.before(createdOn)) {
				context.addMessage("companyForm:activeOn", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Active date cannot be before creation date.", null));
				isValid = false;
			}
			if (expireDate != null && activeOn.after(expireDate)) {
				context.addMessage("companyForm:activeOn", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Active date cannot be after expiry.", null));
				isValid = false;
			}
		}
 
		return isValid;
	}

	public InsurancePlan getInsurancePlan() {
		return insurancePlan;
	}

	public void setInsurancePlan(InsurancePlan insurancePlan) {
		this.insurancePlan = insurancePlan;
	}

	public InsuranceCompany getInsuranceCompany() {
		return insuranceCompany;
	}

	public void setInsuranceCompany(InsuranceCompany insuranceCompany) {
		this.insuranceCompany = insuranceCompany;
	}

	public InsurancePlanDao getPlandao() {
		return plandao;
	}

	public void setPlandao(InsurancePlanDao plandao) {
		this.plandao = plandao;
	}

	public String getShowSuccessMessage() {
		return showSuccessMessage;
	}

	public void setShowSuccessMessage(String showSuccessMessage) {
		this.showSuccessMessage = showSuccessMessage;
	}
	
	
}