package controllers;

import dto.*;
import play.data.Form;
import play.data.FormFactory;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import services.*;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {


    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */

    @Inject
    private FormFactory formFactory;

    public Result saveData(Http.Request request) {
        Form<RegisterationRequestDto> registrationForm =
                formFactory.form(RegisterationRequestDto.class).bindFromRequest(request);
        RegisterationRequestDto requestDto = registrationForm.get();
        RegisterationResponseDto responseDto = RegistrationService.save(requestDto);

        return ok(Json.toJson(responseDto));
    }

    public Result loginCheck(Http.Request request) {
        Form<LoginRequestDto> loginRequestDtoForm =
                formFactory.form(LoginRequestDto.class).bindFromRequest(request);

        LoginRequestDto loginRequestDto = loginRequestDtoForm.get();
        LoginResponseDto loginResponseDto = LoginService.validationCredentials(loginRequestDto);

        return ok(Json.toJson(loginResponseDto));
    }


    public Result sendMoney(Http.Request request) {
        Form<SendMoneyRequestDto> sendMoneyRequestDtoForm
                = formFactory.form(SendMoneyRequestDto.class).bindFromRequest(request);
        SendMoneyRequestDto sendMoneyRequestDto = sendMoneyRequestDtoForm.get();
        SendMoneyResponseDto sendMoneyResponseDto = SendMoneyService.saveDetails(sendMoneyRequestDto);

        return ok(Json.toJson(sendMoneyResponseDto));
    }


    public Result userSearchbutton(Http.Request request) {

        Form<UserSearchRequestDto> userSearchRequestDtoForm
                = formFactory.form(UserSearchRequestDto.class).bindFromRequest(request);

        UserSearchRequestDto userSearchRequestDto = userSearchRequestDtoForm.get();
        UserSearchResponseDto userSearchResponseDto = UserSearchService.deactivateSearch(userSearchRequestDto);

        return ok(Json.toJson(userSearchResponseDto));
    }


    public Result customerDeactivate(Http.Request request) {

        Form<DeactivateButtonRequestDto> deactivateButtonRequestDtoForm
                = formFactory.form(DeactivateButtonRequestDto.class).bindFromRequest(request);

        DeactivateButtonRequestDto deactivateButtonRequestDto = deactivateButtonRequestDtoForm.get();
        DeactivateButtonResponseDto deactivateButtonResponseDto = DeactivateButtonService.deactivateButton(deactivateButtonRequestDto);

        return ok(Json.toJson(deactivateButtonResponseDto));
    }

    public Result accountDetails(Http.Request request) {

        Form<UserSearchRequestDto> accountDetailsRequestDtoForm
                = formFactory.form(UserSearchRequestDto.class).bindFromRequest(request);

        UserSearchRequestDto accountDetailsRequestDto = accountDetailsRequestDtoForm.get();
        UserSearchResponseDto accountDetailsResponseDto = AccountDetailsService.renderDetails(accountDetailsRequestDto);

        return ok(Json.toJson(accountDetailsResponseDto));
    }

    public Result renderTransaction(Http.Request request) {

        List<TransactionHistoryResponseDto> transactionHistoryResponseDtoList = new ArrayList<>();

        Form<TransactionHistoryRequestDto> transactionHistoryRequestDtoForm
                = formFactory.form(TransactionHistoryRequestDto.class).bindFromRequest(request);

        TransactionHistoryRequestDto transactionHistoryRequestDto = transactionHistoryRequestDtoForm.get();
        transactionHistoryResponseDtoList = TransactionHistoryService.listOfCustomers(transactionHistoryRequestDto);

        return ok(Json.toJson(transactionHistoryResponseDtoList));
    }

    public Result customerListRender() {
        List<ViewListResponseDto> viewListResponseDtoList = new ArrayList<>();
        viewListResponseDtoList = ViewListService.listOfCustomers();
        return ok(Json.toJson(viewListResponseDtoList));
    }

    public Result customerActivate(Http.Request request) {
        Form<ActivateButtonRequestDto> activateButtonRequestDtoForm =
                formFactory.form(ActivateButtonRequestDto.class).bindFromRequest(request);

        ActivateButtonRequestDto activateButtonRequestDto = activateButtonRequestDtoForm.get();
        ActivateButtonResponseDto activateButtonResponseDto = ActivateButtonService.userActive(activateButtonRequestDto);

        return ok(Json.toJson(activateButtonResponseDto));
    }
}
