package DomainLayer;

import java.io.*;
import java.util.*;

/**
 * 
 */
public class PricingRule {

    /**
     * Default constructor
     */
    public PricingRule() {
    }

    /**
     * 
     */
    private String ruleID;

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private String appliesToType;

    /**
     * 
     */
    private String daysOfWeek;

    /**
     * 
     */
    private String timeWindow;

    /**
     * 
     */
    private float adjustment;

    /**
     * 
     */


    /**
     * @param date 
     * @return
     */
    public boolean isActive(Date date) {
      
        return false;
    }

}