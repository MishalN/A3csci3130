package com.acme.a3csci3130;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


/**
 *
 * Mishal Alnajdi
 * B00562408
 * Assignment 4
 */

/**
 * Class that defines how the data will be stored in the
 * Firebase databse. This is converted to a JSON format
 */
public class BusinessData implements Serializable {

    public String uid;
    public String businessNumber;
    public String name;
    public String primaryBusiness;
    public String address;
    public String province;


    public BusinessData() {
        // Default constructor required for calls to DataSnapshot.getValue
    }

    /**
     *
     * @param uid unique ID for each child.
     * @param businessNumber business number of 9 digit.
     * @param name the name (2-48 characters).
     * @param primaryBusiness one of (Fisher, Distributor, Processor, Fish Monger).
     * @param address adress les than 50 characters.
     * @param province one of (AB, BC, MB, NB, NL, NS, NT, NU, ON, PE, QC, SK, YT, “ “)
     */
    public BusinessData(String uid, String businessNumber, String name, String primaryBusiness, String address, String province ){
        this.uid = uid;
        this.businessNumber = businessNumber;
        this.name = name;
        this.primaryBusiness = primaryBusiness;
        this.address = address;
        this.province = province;


    }

    /**
     *
     * @return Hashmap called result with 6 parameters.
     */
    @Exclude
    public Map<String, Object> toMap(){
        HashMap<String, Object> result = new HashMap<>();
        result.put("uid", uid);
        result.put("businessNumber", businessNumber);
        result.put("name", name);
        result.put("primaryBusiness", primaryBusiness);
        result.put("address", address);
        result.put("province", province);

        return result;
    }
}
