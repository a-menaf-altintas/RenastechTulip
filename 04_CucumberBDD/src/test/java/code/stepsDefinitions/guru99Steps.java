package code.stepsDefinitions;

import code.pages.guru99Home;
import code.pages.guru99OrderSuccess;
import code.pages.guru99Payment;
import code.utils.BrowserUtils;
import code.utils.ConfigurationsReader;
import code.utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class guru99Steps extends BrowserUtils {
    guru99Home guru99Home=new guru99Home();
    guru99Payment guru99Payment=new guru99Payment();
    guru99OrderSuccess guru99OrderSuccess=new guru99OrderSuccess();

    @Given("The user wants to go to Payment Gateway Website")
    public void the_user_wants_to_go_to_payment_gateway_website() {
        Driver.getDriver().get(ConfigurationsReader.getProperties("demoURL"));
        setWaitTime();
    }
    @When("The user wants to buy an elephant toy")
    public void the_user_wants_to_buy_an_elephant_toy() {
        guru99Home.getQuantityDropdown("1");
        guru99Home.getBuyNowButton();
    }
    @Then("The user wants to provide requested payment information")
    public void the_user_wants_to_provide_requested_payment_information() {
        guru99Payment.setCardNumber("5454545454545454");
        guru99Payment.setMonth("10");
        guru99Payment.setYear("2024");
        guru99Payment.setCvv_code("369");
    }
    @Then("The user wants to click on pay now")
    public void the_user_wants_to_click_on_pay_now() {
        guru99Payment.setPayButton();
    }
    @Then("The user wants to verify order is successful")
    public void the_user_wants_to_verify_order_is_successful() {

        guru99OrderSuccess.setVerificationText("Payment successfull!");
    }



}