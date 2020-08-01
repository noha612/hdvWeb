package service.paypal;

import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.OAuthTokenCredential;
import com.paypal.base.rest.PayPalRESTException;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import constant.Constants;

public class PaypalConfig {


    public Map<String, String> paypalSdkConfig() {
        Map<String, String> configMap = new HashMap<>();
        configMap.put("mode", Constants.PAYPAL_MODE);
        return configMap;
    }

    public OAuthTokenCredential oAuthTokenCredential() {
        return new OAuthTokenCredential(Constants.PAYPAL_CLIENT_ID, Constants.PAYPAL_CLIENT_SECRET, paypalSdkConfig());
    }

    public APIContext apiContext() {
        try {
            APIContext context = new APIContext(oAuthTokenCredential().getAccessToken());
            context.setConfigurationMap(paypalSdkConfig());
            return context;
        } catch (PayPalRESTException ex) {
            Logger.getLogger(PaypalConfig.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
