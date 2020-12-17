package com.example.agripoc.services.api;


import com.example.agripoc.dto.LoginnewResponseDTO;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface AppAPI {

/*
*
*
*
curl -X GET \
  https://farmmobi.in/apis/poc/whois \
  -H 'Content-Type: application/json' \
  -H 'Postman-Token: a8e5d1ee-e268-4cb3-b7fe-eb885c211eba' \
  -H 'cache-control: no-cache' \
  -d '{"company_code": "ABC", "app_key": "986d974e0eb1576a1a97d56da9725273bb865d0c649865b3575ff9895a5ceb82"}'

2. Login with username/password

curl -X GET \
  https://farmmobi.in/apis/poc/login \
  -H 'Content-Type: application/json' \
  -H 'Postman-Token: 032f3478-1486-45be-b292-ef419bbaa332' \
  -H 'cache-control: no-cache' \
  -d '{"company_code": "ABC", "app_key": "986d974e0eb1576a1a97d56da9725273bb865d0c649865b3575ff9895a5ceb82",
"username": "demo@abcfarms.in", "password": "demo!@#$%"
}'

3.  Login with api key (to be used after registration so no need to ask password each time user opens app)

curl -X GET \
  https://farmmobi.in/apis/poc/keylogin \
  -H 'Content-Type: application/json' \
  -H 'Postman-Token: 59f3affd-244b-4313-9238-399bd4135759' \
  -H 'cache-control: no-cache' \
  -d '{"company_code": "ABC", "app_key": "986d974e0eb1576a1a97d56da9725273bb865d0c649865b3575ff9895a5ceb82",
"api-key":"af4c952fa3b1df0412f1ed9ff45ef77f3442ddcc7a2d0ef1927afe16e5f9201e"}'

4. Records: (this api accepts size like {{api_url}}apis/poc/records?size=100 )

curl -X GET \
  https://farmmobi.in/apis/poc/records \
  -H 'Content-Type: application/json' \
  -H 'Postman-Token: 990ad851-8f8e-40bc-8c96-4ffe40cecf36' \
  -H 'cache-control: no-cache' \
  -d '{"company_code": "ABC", "app_key": "986d974e0eb1576a1a97d56da9725273bb865d0c649865b3575ff9895a5ceb82",
"api-key":"af4c952fa3b1df0412f1ed9ff45ef77f3442ddcc7a2d0ef1927afe16e5f9201e"}'

Size for 20000 records in json is ~10MB so we need to define our main data records to keep this at minimum and modular.

Each request will have:
- "app_key" . We need to put some key in the mobile app.
- company_code: Unique for each customer
- api-key: Unique for each user
* */
    // TODO: LOGIN SERVICE
    @POST("login")
    Call<LoginnewResponseDTO> logInService(@Body LoginNewRequestDTO loginRequestDTO);


    @POST("login")
    Call<LoginnewResponseDTO> logInService(@Body LoginNewRequestDTO loginRequestDTO);


}
