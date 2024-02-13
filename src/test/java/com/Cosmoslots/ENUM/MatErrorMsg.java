/**
 * 
 */
package com.Cosmoslots.ENUM;

/**
 * @author shrikrushna.sonkar
 *
 */
public enum MatErrorMsg {
	Firstname_Error_msg("//mat-error[text()=' First name is required']"),
	Lastname_Error_msg("//mat-error[text()=' Last name is required']"),
	Username_Error_msg("//mat-error[text()=' User Name is required']"),
	Designation_Error_msg("//mat-error[text()=' Designation is required']"),
	ParentUser_Error_msg("//mat-error[text()=' Parent User is required']"),
	Email_Error_msg("//mat-error[text()=' Email is required']"),
	Country_Error_msg("//mat-error[text()=' Country is required']"),
	State_Error_msg("//mat-error[text()=' State is required']"),
	PTSTL_Error_msg("//mat-error[text()=' Per Transaction Sweep Tokens Limit required']"),
	PDTSTL_Error_msg("//mat-error[text()=' Per Day Transaction Sweep Tokens Limit required']"),
	RegistratinCode_Error_msg("//mat-error[text()='  Registration code is required'"),
	Newpassword_Error_msg("//mat-error[text()=' New password is required ']"),
	Confirmpassword_Error_msg("//mat-error[text()=' Confirm password is required ']"),;

	private final String error_msg;

	private MatErrorMsg(String string) {
		this.error_msg = string;
	}

	public String getErrorValues() {
		return error_msg;
	}

}
