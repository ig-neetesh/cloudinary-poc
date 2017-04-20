package com.ttn.poc;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by neetesh on 31/3/17.
 */
public final class CommonUtil {
    public static final Map<String, String> CONFIG = new HashMap<String, String>();

    static {
        CONFIG.put("cloud_name", "tatasky-qa");
        CONFIG.put("api_key", "638265156888557");
        CONFIG.put("api_secret", "0klRYna2hovUMgvtNZfSOJgNPtg");
    }

}
