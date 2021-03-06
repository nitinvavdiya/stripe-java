package com.stripe.model;

import com.stripe.exception.APIConnectionException;
import com.stripe.exception.APIException;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.net.APIResource;
import com.stripe.net.RequestOptions;

import java.util.Collections;
import java.util.Map;

public class Charge extends APIResource implements MetadataStore<Charge>, HasId {
	public static final String FRAUD_DETAILS = "fraud_details";

	String id;
	Integer amount;
	Integer amountRefunded;
	String applicationFee;
	String balanceTransaction;
	Boolean captured;
	Long created;
	String currency;
	String customer;
	String description;
	String destination;
	Dispute dispute;
	String failureCode;
	String failureMessage;
	FraudDetails fraudDetails;
	String invoice;
	Boolean livemode;
	Map<String, String> metadata;
	ChargeOutcome outcome;
	String order;
	Boolean paid;
	String receiptEmail;
	String receiptNumber;
	Boolean refunded;
	ChargeRefundCollection refunds;
	ShippingDetails shipping;
	ExternalAccount source;
	String sourceTransfer;
	String statementDescriptor;
	String status;
	String transfer;

	@Deprecated
	Card card;
	/** Legacy; use `dispute` field (https://stripe.com/docs/upgrades#2012-11-07) */
	@Deprecated
	Boolean disputed;
	@Deprecated
	String statementDescription;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Integer getAmountRefunded() {
		return amountRefunded;
	}

	public void setAmountRefunded(Integer amountRefunded) {
		this.amountRefunded = amountRefunded;
	}

	public String getApplicationFee() {
		return applicationFee;
	}

	public void setApplicationFee(String applicationFee) {
		this.applicationFee = applicationFee;
	}

	public String getBalanceTransaction() {
		return balanceTransaction;
	}

	public void setBalanceTransaction(String balanceTransaction) {
		this.balanceTransaction = balanceTransaction;
	}

	public Boolean getCaptured() {
		return captured;
	}

	public void setCaptured(Boolean captured) {
		this.captured = captured;
	}

	public Long getCreated() {
		return created;
	}

	public void setCreated(Long created) {
		this.created = created;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Dispute getDispute() {
		return dispute;
	}

	public void setDispute(Dispute dispute) {
		this.dispute = dispute;
	}

	public String getFailureCode() {
		return failureCode;
	}

	public void setFailureCode(String failureCode) {
		this.failureCode = failureCode;
	}

	public String getFailureMessage() {
		return failureMessage;
	}

	public void setFailureMessage(String failureMessage) {
		this.failureMessage = failureMessage;
	}

	public FraudDetails getFraudDetails() {
		return fraudDetails;
	}

	public void setFraudDetails(FraudDetails fraudDetails) {
		this.fraudDetails = fraudDetails;
	}

	public String getInvoice() {
		return invoice;
	}

	public void setInvoice(String invoice) {
		this.invoice = invoice;
	}

	public Boolean getLivemode() {
		return livemode;
	}

	public void setLivemode(Boolean livemode) {
		this.livemode = livemode;
	}

	public Map<String, String> getMetadata() {
		return metadata;
	}

	public void setMetadata(Map<String, String> metadata) {
		this.metadata = metadata;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public ChargeOutcome getOutcome() {
		return outcome;
	}

	public void setOutcome(ChargeOutcome outcome) {
		this.outcome = outcome;
	}

	public Boolean getPaid() {
		return paid;
	}

	public void setPaid(Boolean paid) {
		this.paid = paid;
	}

	public String getReceiptEmail() {
		return receiptEmail;
	}

	public void setReceiptEmail(String receiptEmail) {
		this.receiptEmail = receiptEmail;
	}

	public String getReceiptNumber() {
		return receiptNumber;
	}

	public void setReceiptNumber(String receiptNumber) {
		this.receiptNumber = receiptNumber;
	}

	public Boolean getRefunded() {
		return refunded;
	}

	public void setRefunded(Boolean refunded) {
		this.refunded = refunded;
	}

	public ChargeRefundCollection getRefunds() {
		// API versions 2014-05-19 and earlier render charge refunds as an array
		// instead of an object, meaning there is no sublist URL.
		if (refunds != null && refunds.getURL() == null) {
			refunds.setURL(String.format("/v1/charges/%s/refunds", getId()));
		}
		return refunds;
	}

	public ShippingDetails getShipping() {
		return shipping;
	}

	public void setShipping(ShippingDetails shipping) {
		this.shipping = shipping;
	}

	public ExternalAccount getSource() {
		return source;
	}

	public void setSource(ExternalAccount source) {
		this.source = source;
	}

	public String getSourceTransfer() {
		return sourceTransfer;
	}

	public void setSourceTransfer(String sourceTransfer) {
		this.sourceTransfer = sourceTransfer;
	}

	public String getStatementDescriptor() {
		return statementDescriptor;
	}

	public void setStatementDescriptor(String statementDescriptor) {
		this.statementDescriptor = statementDescriptor;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTransfer() {
		return transfer;
	}

	public void setTransfer(String transfer) {
		this.transfer = transfer;
	}

	/**
	 * @deprecated
	 * Use `source` field (https://stripe.com/docs/upgrades#2015-02-18)
	 */
	@Deprecated
	public Card getCard() {
		return card;
	}

	/**
	 * @deprecated
	 * Use `source` field (https://stripe.com/docs/upgrades#2015-02-18)
	 */
	@Deprecated
	public void setCard(Card card) {
		this.card = card;
	}

	/**
	 * @deprecated
	 * Use `dispute` field (https://stripe.com/docs/upgrades#2012-11-07)
	 */
	@Deprecated
	public Boolean getDisputed() {
		return disputed;
	}

	/**
	 * @deprecated
	 * Use `dispute` field (https://stripe.com/docs/upgrades#2012-11-07)
	 */
	@Deprecated
	public void setDisputed(Boolean disputed) {
		this.disputed = disputed;
	}

	/**
	 * @deprecated
	 * Use `statement_descriptor` field (https://stripe.com/docs/upgrades#2014-12-17)
	 */
	@Deprecated
	public String getStatementDescription() {
		return statementDescription;
	}

	/**
	 * @deprecated
	 * Use `statement_descriptor` field (https://stripe.com/docs/upgrades#2014-12-17)
	 */
	@Deprecated
	public void setStatementDescription(String statementDescription) {
		this.statementDescription = statementDescription;
	}

	public static Charge create(Map<String, Object> params)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, CardException, APIException {
		return create(params, (RequestOptions) null);
	}

	public static Charge retrieve(String id) throws AuthenticationException,
			InvalidRequestException, APIConnectionException, CardException,
			APIException {
		return retrieve(id, (RequestOptions) null);
	}

	public Charge update(Map<String, Object> params)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, CardException, APIException {
		return update(params, (RequestOptions) null);
	}

	public Charge refund() throws AuthenticationException,
			InvalidRequestException, APIConnectionException, CardException,
			APIException {
		return this.refund(null, (RequestOptions) null);
	}

	public Charge capture() throws AuthenticationException,
			InvalidRequestException, APIConnectionException, CardException,
			APIException {
		return this.capture(null, (RequestOptions) null);
	}

	@Deprecated
	public Dispute updateDispute(Map<String, Object> params)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, CardException, APIException {
		return this.updateDispute(params, (RequestOptions) null);
	}

	@Deprecated
	public Dispute closeDispute() throws AuthenticationException,
			InvalidRequestException, APIConnectionException, CardException,
			APIException {
		return this.closeDispute((RequestOptions) null);
	}

	public Charge refund(Map<String, Object> params)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, CardException, APIException {
		return this.refund(params, (RequestOptions) null);
	}

	public Charge capture(Map<String, Object> params)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, CardException, APIException {
		return this.capture(params, (RequestOptions) null);
	}

	@Deprecated
	public static Charge create(Map<String, Object> params, String apiKey)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, CardException, APIException {
		return create(params, RequestOptions.builder().setApiKey(apiKey).build());
	}
	public static Charge create(Map<String, Object> params, RequestOptions options)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, CardException, APIException {
		return request(RequestMethod.POST, classURL(Charge.class), params, Charge.class, options);
	}

	@Deprecated
	public static Charge retrieve(String id, String apiKey)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, CardException, APIException {
		return retrieve(id, RequestOptions.builder().setApiKey(apiKey).build());
	}
	public static Charge retrieve(String id, RequestOptions options)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, CardException, APIException {
		return request(RequestMethod.GET, instanceURL(Charge.class, id), null, Charge.class, options);
	}

	@Deprecated
	public Charge update(Map<String, Object> params, String apiKey)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, CardException, APIException {
		return update(params, RequestOptions.builder().setApiKey(apiKey).build());
	}
	public Charge update(Map<String, Object> params, RequestOptions options)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, CardException, APIException {
		return request(RequestMethod.POST, instanceURL(Charge.class, id), params, Charge.class, options);
	}

	public static ChargeCollection list(Map<String, Object> params)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, CardException, APIException {
		return list(params, (RequestOptions) null);
	}

	public static ChargeCollection list(Map<String, Object> params, RequestOptions options)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, CardException, APIException {
		return requestCollection(classURL(Charge.class), params, ChargeCollection.class, options);
	}

	@Deprecated
	public static ChargeCollection all(Map<String, Object> params)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, CardException, APIException {
		return list(params, (RequestOptions) null);
	}

	@Deprecated
	public static ChargeCollection all(Map<String, Object> params, String apiKey)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, CardException, APIException {
		return list(params, RequestOptions.builder().setApiKey(apiKey).build());
	}

	@Deprecated
	public static ChargeCollection all(Map<String, Object> params, RequestOptions options)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, CardException, APIException {
		return list(params, options);
	}

	@Deprecated
	public Charge refund(String apiKey) throws AuthenticationException,
			InvalidRequestException, APIConnectionException, CardException,
			APIException {
		return this.refund(RequestOptions.builder().setApiKey(apiKey).build()); // full refund
	}
	public Charge refund(RequestOptions options) throws AuthenticationException,
			InvalidRequestException, APIConnectionException, CardException,
			APIException {
		return this.refund(null, options); // full refund
	}

	@Deprecated
	public Charge refund(Map<String, Object> params, String apiKey)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, CardException, APIException {
		return refund(params, RequestOptions.builder().setApiKey(apiKey).build());
	}
	public Charge refund(Map<String, Object> params, RequestOptions options)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, CardException, APIException {
		return request(RequestMethod.POST, String.format("%s/refund",
				instanceURL(Charge.class, this.getId())), params, Charge.class, options);
	}

	@Deprecated
	public Charge capture(String apiKey) throws AuthenticationException,
			InvalidRequestException, APIConnectionException, CardException,
			APIException {
		return capture(RequestOptions.builder().setApiKey(apiKey).build());
	}
	public Charge capture(RequestOptions options) throws AuthenticationException,
			InvalidRequestException, APIConnectionException, CardException,
			APIException {
		return this.capture(null, options);
	}

	@Deprecated
	public Charge capture(Map<String, Object> params, String apiKey)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, CardException, APIException {
		return capture(params, RequestOptions.builder().setApiKey(apiKey).build());
	}
	public Charge capture(Map<String, Object> params, RequestOptions options)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, CardException, APIException {
		return request(RequestMethod.POST, String.format("%s/capture",
						instanceURL(Charge.class, this.getId())), params, Charge.class, options);
	}

	@Deprecated
	public Dispute updateDispute(Map<String, Object> params, String apiKey)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, CardException, APIException {
		return updateDispute(params, RequestOptions.builder().setApiKey(apiKey).build());
	}

	@Deprecated
	public Dispute updateDispute(Map<String, Object> params, RequestOptions options)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, CardException, APIException {
		return request(RequestMethod.POST, String.format("%s/dispute", instanceURL(Charge.class, this.id)), params, Dispute.class, options);
	}

	@Deprecated
	public Dispute closeDispute(String apiKey)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, CardException, APIException {
		return closeDispute(RequestOptions.builder().setApiKey(apiKey).build());
	}

	@Deprecated
	public Dispute closeDispute(RequestOptions options)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, CardException, APIException {
		return request(RequestMethod.POST, String.format("%s/dispute/close", instanceURL(Charge.class, this.getId())), null, Dispute.class, options);
	}

	/**
	 * Convenience method to mark a given charge as fraudulent.
	 */
	public Charge markFraudulent(RequestOptions options)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, CardException, APIException {
		Map<String, Object> params = Collections.<String, Object>singletonMap(FRAUD_DETAILS, Collections.singletonMap(FraudDetails.USER_REPORT, "fraudulent"));
		return this.update(params, options);
	}

	/**
	 * Convenience method to mark a given charge as not fraudulent.
	 */
	public Charge markSafe(RequestOptions options)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, CardException, APIException {
		Map<String, Object> params = Collections.<String, Object>singletonMap(FRAUD_DETAILS, Collections.singletonMap(FraudDetails.USER_REPORT, "safe"));
		return this.update(params, options);
	}
}
