package ibf2022.tfip.ssf.day17workshopCurrencyConverterApi.model;

public class Currency {
    private String result;
    private long timeLastUpdateUnix;
    private String timeLastUpdateUTC;
    private long timeNextUpdateUnix;
    private String timeNextUpdateUTC;
    private String baseCode;
    private String targetCode;
    private float conversionRate;

    public String getResult() {return result;}
    public void setResult(String result) {this.result = result;}

    public long getTimeLastUpdateUnix() {return timeLastUpdateUnix;}
    public void setTimeLastUpdateUnix(long timeLastUpdateUnix) {this.timeLastUpdateUnix = timeLastUpdateUnix;}

    public String getTimeLastUpdateUTC() {return timeLastUpdateUTC;}
    public void setTimeLastUpdateUTC(String timeLastUpdateUTC) {this.timeLastUpdateUTC = timeLastUpdateUTC;}

    public long getTimeNextUpdateUnix() {return timeNextUpdateUnix;}
    public void setTimeNextUpdateUnix(long timeNextUpdateUnix) {this.timeNextUpdateUnix = timeNextUpdateUnix;}

    public String getTimeNextUpdateUTC() {return timeNextUpdateUTC;}
    public void setTimeNextUpdateUTC(String timeNextUpdateUTC) {this.timeNextUpdateUTC = timeNextUpdateUTC;}

    public String getBaseCode() {return baseCode;}
    public void setBaseCode(String baseCode) {this.baseCode = baseCode;}

    public String getTargetCode() {return targetCode;}
    public void setTargetCode(String targetCode) {this.targetCode = targetCode;}

    public float getConversionRate(){return conversionRate;}
    public void setConversionRate(float conversionRate) {this.conversionRate = conversionRate;}
    
    @Override
    public String toString() {
        return "Currency [result=" + result + ", timeLastUpdateUnix=" + timeLastUpdateUnix + ", timeLastUpdateUTC="
                + timeLastUpdateUTC + ", timeNextUpdateUnix=" + timeNextUpdateUnix + ", timeNextUpdateUTC="
                + timeNextUpdateUTC + ", baseCode=" + baseCode + ", targetCode=" + targetCode + ", conversionRate="
                + conversionRate + "]";
    }

    
}
