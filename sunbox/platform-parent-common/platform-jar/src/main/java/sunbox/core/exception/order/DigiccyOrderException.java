package sunbox.core.exception.order;

import sunbox.core.exception.BaseCommonException;

public class DigiccyOrderException extends BaseCommonException {
    public DigiccyOrderException(){
        this.errorCode=70011;//
        this.errorInfo="数字货币离线充电交易上行数据重复上送";
    }
}
