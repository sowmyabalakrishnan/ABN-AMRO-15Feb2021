/**
 * 
 */
package processor;

/**
 * @author Sowmya
 *CLIENT TYPE, CLIENT NUMBER, ACCOUNT NUMBER, SUBACCOUNT NUMBER 
 *EXCHANGE CODE, PRODUCT GROUP CODE, SYMBOL, EXPIRATION DATE
 *QUANTITY LONG - QUANTITY SHORT
 */
public class MyRecord {
	    public String clientType;
	    public int clientNumber;
	    public int accountNumber;
	    public int subAccountNumber;
	    public String exchangeCode;
	    public String productGroupCode;
	    public String symbol;
	    public String expirationDate;
	    public int quantityLong;
	    public int quantityShort;
	    
		/**
		 * @return the clientType
		 */
		public String getClientType() {
			return clientType;
		}
		/**
		 * @param clientType the clientType to set
		 */
		public void setClientType(String clientType) {
			this.clientType = clientType;
		}
		/**
		 * @return the clientNumber
		 */
		public int getClientNumber() {
			return clientNumber;
		}
		/**
		 * @param clientNumber the clientNumber to set
		 */
		public void setClientNumber(int clientNumber) {
			this.clientNumber = clientNumber;
		}
		/**
		 * @return the accountNumber
		 */
		public int getAccountNumber() {
			return accountNumber;
		}
		/**
		 * @param accountNumber the accountNumber to set
		 */
		public void setAccountNumber(int accountNumber) {
			this.accountNumber = accountNumber;
		}
		/**
		 * @return the subAccountNumber
		 */
		public int getSubAccountNumber() {
			return subAccountNumber;
		}
		/**
		 * @param subAccountNumber the subAccountNumber to set
		 */
		public void setSubAccountNumber(int subAccountNumber) {
			this.subAccountNumber = subAccountNumber;
		}
		/**
		 * @return the exchangeCode
		 */
		public String getExchangeCode() {
			return exchangeCode;
		}
		/**
		 * @param exchangeCode the exchangeCode to set
		 */
		public void setExchangeCode(String exchangeCode) {
			this.exchangeCode = exchangeCode;
		}
		/**
		 * @return the productGroupCode
		 */
		public String getProductGroupCode() {
			return productGroupCode;
		}
		/**
		 * @param productGroupCode the productGroupCode to set
		 */
		public void setProductGroupCode(String productGroupCode) {
			this.productGroupCode = productGroupCode;
		}
		/**
		 * @return the symbol
		 */
		public String getSymbol() {
			return symbol;
		}
		/**
		 * @param symbol the symbol to set
		 */
		public void setSymbol(String symbol) {
			this.symbol = symbol;
		}
		/**
		 * @return the expirationDate
		 */
		public String getExpirationDate() {
			return expirationDate;
		}
		/**
		 * @param expirationDate the expirationDate to set
		 */
		public void setExpirationDate(String expirationDate) {
			this.expirationDate = expirationDate;
		}
		/**
		 * @return the quantityLong
		 */
		public int getQuantityLong() {
			return quantityLong;
		}
		/**
		 * @param quantityLong the quantityLong to set
		 */
		public void setQuantityLong(int quantityLong) {
			this.quantityLong = quantityLong;
		}
		/**
		 * @return the quantityShort
		 */
		public int getQuantityShort() {
			return quantityShort;
		}
		/**
		 * @param quantityShort the quantityShort to set
		 */
		public void setQuantityShort(int quantityShort) {
			this.quantityShort = quantityShort;
		}
	    

	    
}
