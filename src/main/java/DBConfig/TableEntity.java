package DBConfig;

import sun.dc.pr.PRError;

/**
 * Created by hitek on 04.07.2017.
 */
public class TableEntity {

    private int ID;
    private String URL;
    private int STATUS_RESPONSE_CODE;
    private int PERIOD_MMONITORING;
    private int TIME_RESPONSE_OK;
    private int TIME_RESPONSE_WARNING;
    private int TIME_RESPONSE_CRITICAL;
    private int RESPONSE_SIZE_MIN;
    private int RESPONSE_SIZE_MAX;


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public int getSTATUS_RESPONSE_CODE() {
        return STATUS_RESPONSE_CODE;
    }

    public void setSTATUS_RESPONSE_CODE(int STATUS_RESPONSE_CODE) {
        this.STATUS_RESPONSE_CODE = STATUS_RESPONSE_CODE;
    }

    public int getPERIOD_MMONITORING() {
        return PERIOD_MMONITORING;
    }

    public void setPERIOD_MMONITORING(int PERIOD_MMONITORING) {
        this.PERIOD_MMONITORING = PERIOD_MMONITORING;
    }

    public int getTIME_RESPONSE_OK() {
        return TIME_RESPONSE_OK;
    }

    public void setTIME_RESPONSE_OK(int TIME_RESPONSE_OK) {
        this.TIME_RESPONSE_OK = TIME_RESPONSE_OK;
    }

    public int getTIME_RESPONSE_WARNING() {
        return TIME_RESPONSE_WARNING;
    }

    public void setTIME_RESPONSE_WARNING(int TIME_RESPONSE_WARNING) {
        this.TIME_RESPONSE_WARNING = TIME_RESPONSE_WARNING;
    }

    public int getTIME_RESPONSE_CRITICAL() {
        return TIME_RESPONSE_CRITICAL;
    }

    public void setTIME_RESPONSE_CRITICAL(int TIME_RESPONSE_CRITICAL) {
        this.TIME_RESPONSE_CRITICAL = TIME_RESPONSE_CRITICAL;
    }

    public int getRESPONSE_SIZE_MIN() {
        return RESPONSE_SIZE_MIN;
    }

    public void setRESPONSE_SIZE_MIN(int RESPONSE_SIZE_MIN) {
        this.RESPONSE_SIZE_MIN = RESPONSE_SIZE_MIN;
    }

    public int getRESPONSE_SIZE_MAX() {
        return RESPONSE_SIZE_MAX;
    }

    public void setRESPONSE_SIZE_MAX(int RESPONSE_SIZE_MAX) {
        this.RESPONSE_SIZE_MAX = RESPONSE_SIZE_MAX;
    }
}
