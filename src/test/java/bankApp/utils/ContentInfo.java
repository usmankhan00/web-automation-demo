package bankApp.utils;

/**
 * This class is used for content name and build id.
 */
public class ContentInfo {

    private String contentName;

    private String buildId;

    private String scheduleActivationTime;

    private boolean isMarketIsDifferent;

    private String downloadFilePath;

    /**
     * @return download file path initialized.
     */
    public String getDownloadFilePath() {
        return downloadFilePath;
    }

    /**
     * @param downloadFilePath is to be initialized.
     */
    public void setDownloadFilePath(String downloadFilePath) {
        this.downloadFilePath = downloadFilePath;
    }

    /**
     * @return Content name initialized.
     */
    public String getContentName() {
        return contentName;
    }

    /**
     * @param contentName is to be initialized.
     */
    public void setContentName(String contentName) {
        this.contentName = contentName;
    }

    /**
     * @return build Id.
     */
    public String getBuildId() {
        return buildId;
    }

    /**
     * @param buildId is to be initialized.
     */
    public void setBuildId(String buildId) {
        this.buildId = buildId;
    }

    /**
     * @return schedule activation time.
     */
    public String getScheduleActivationTime() {
        return scheduleActivationTime;
    }

    /**
     * @param scheduleActivationTime is to be initialized.
     */
    public void setScheduleActivationTime(String scheduleActivationTime) {
        this.scheduleActivationTime = scheduleActivationTime;
    }

    /**
     * @return is market is different or not.
     */
    public boolean getIsMarketIsDifferent() {
        return isMarketIsDifferent;
    }

    /**
     * @param marketIsDifferent is to be initialized.
     */
    public void setMarketIsDifferent(boolean marketIsDifferent) {
        isMarketIsDifferent = marketIsDifferent;
    }
}
