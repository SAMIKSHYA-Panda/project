//package com.infinite.jsf.insurance.model;
//
///**
// * Enum representing the types of insurance plans. Each type maps to a database
// * value.
// * 
// * Example types: SELF, FAMILY, SENIOR, etc.
// */
//public enum PlanType {
//	SELF, FAMILY, SENIOR, CRITICAL_ILLNESS
////    ELITE_HEALTH("ELITE_HEALTH");
//
//}


package com.infinite.jsf.insurance.model;
 
public enum PlanType {
    SELF,
    FAMILY,
    SENIOR,
    CRITICAL_ILLNESS,
    SUPER_ELITE,       // <--- this MUST exist
    EPIDEMIC_PROTECT
}