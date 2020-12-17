package com.example.agripoc.viewmodel;

import android.content.Context;
import android.widget.ProgressBar;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.rblfinserve.rvf.adapter.ClientDetailsAdapter;
import com.rblfinserve.rvf.database.entity.BRETable;
import com.rblfinserve.rvf.database.entity.DEDUPUTable;
import com.rblfinserve.rvf.database.entity.DocumentMasterTable;
import com.rblfinserve.rvf.database.entity.DocumentUploadTableNew;
import com.rblfinserve.rvf.database.entity.FCUTable;
import com.rblfinserve.rvf.database.entity.FIMasterTable;
import com.rblfinserve.rvf.database.entity.LandholdingCategoryTable;
import com.rblfinserve.rvf.database.entity.LeadTable;
import com.rblfinserve.rvf.database.entity.LegalTable;
import com.rblfinserve.rvf.database.entity.MasterTable;
import com.rblfinserve.rvf.database.entity.OTPVerificationTable;
import com.rblfinserve.rvf.database.entity.RAMPTable;
import com.rblfinserve.rvf.database.entity.RawDataTable;
import com.rblfinserve.rvf.database.entity.SubmitDataTable;
import com.rblfinserve.rvf.models.AadhaarVaultResponseDTO;
import com.rblfinserve.rvf.models.AppStoreResponseDTO;
import com.rblfinserve.rvf.models.BearerTokenRequestDTO;
import com.rblfinserve.rvf.models.BearerTokenResponseDTO;
import com.rblfinserve.rvf.models.DocumentUploadRawdataResponseDTO;
import com.rblfinserve.rvf.models.EKYCResponseDTO;
import com.rblfinserve.rvf.models.LogOutResponseDTO;
import com.rblfinserve.rvf.models.LoginResDTO;
import com.rblfinserve.rvf.models.LoginResponseDTO;
import com.rblfinserve.rvf.models.LoginnewResponseDTO;
import com.rblfinserve.rvf.models.NumberOfCoApplicant;
import com.rblfinserve.rvf.models.OTPTriggerDTO;
import com.rblfinserve.rvf.models.OTPTriggerResponseDTO;
import com.rblfinserve.rvf.models.OTPVerifyDTO;
import com.rblfinserve.rvf.models.OTPVerifyResponseDTO;
import com.rblfinserve.rvf.models.PanValidationResponseDTO;
import com.rblfinserve.rvf.models.PincodeResponseDTO;
import com.rblfinserve.rvf.models.RawDataResponseDTO;
import com.rblfinserve.rvf.models.RmLeads;
import com.rblfinserve.rvf.repositories.AppRepository;

import java.util.List;

import javax.inject.Inject;

public class AppViewModel extends ViewModel {

    private AppRepository appRepository;

    private LiveData<LoginResponseDTO> loginResponseDTOLiveData;
    private LiveData<LoginResDTO> loginNewResponseDTOLiveData;
    private LiveData<OTPTriggerResponseDTO> otpTriggerResponseDTOLiveData;
    private LiveData<OTPVerifyResponseDTO> otpVerifyResponseDTOLiveData;
    private LiveData<AppStoreResponseDTO> appStoreResponseDTOLiveData;
    private LiveData<String> stringLiveData;
    private LiveData<BearerTokenResponseDTO> bearerTokenResponseDTOLiveData;
    private LiveData<LoginnewResponseDTO> loginnewResponseDTOLiveData;
    private LiveData<LogOutResponseDTO> logOutResponseDTOLiveData;
    private LiveData<LeadTable> leadTableLiveData;
    private LiveData<PanValidationResponseDTO> panValidationResponseDTOLiveData;
    private LiveData<PincodeResponseDTO> pincodeResponseDTOLiveData;
    private LiveData<AadhaarVaultResponseDTO> aadhaarVaultResponseDTOLiveData;
    private LiveData<EKYCResponseDTO> ekycResponseDTOLiveData;
    private LiveData<RawDataTable> rawDataTableLiveData;
    private LiveData<List<RawDataTable>> rawDataTableLiveDataList;
    private LiveData<List<LeadTable>> leadTableLiveDataList;
    private LiveData<List<BRETable>> cibilTableLiveDataList;
    private LiveData<List<RAMPTable>> rampTableLiveDataList;
    private LiveData<List<DEDUPUTable>> dedupuTableLiveDataList;
    private LiveData<List<FCUTable>> fcuTableLiveDataList;
    private LiveData<List<LegalTable>> legalTableLiveDataList;
    private LiveData<List<MasterTable>> masterTableLiveDataList;
    private LiveData<List<FIMasterTable>> fiMasterTableLiveDataList;
    private LiveData<List<RawDataTable>> rawTableLiveData;
    private LiveData<List<ClientDetailsAdapter>> clientDetailsAdapterList;
    private LiveData<List<DocumentUploadTableNew>> documentUploadLiveDataList;
    private LiveData<List<DocumentMasterTable>> documentMasterListLiveData;
    private LiveData<NumberOfCoApplicant> numberOfCoApplicantLiveData;
    private LiveData<List<OTPVerificationTable>> otpVerificationLiveData;
    private LiveData<List<DocumentUploadRawdataResponseDTO>> documentUploadRawDataResponseList;
    private LiveData<MasterTable> masterTableLiveData;
    private LiveData<FIMasterTable> fiMasterTableLiveData;
    private LiveData<List<String>> stringListLiveData;
    private LiveData<RmLeads> rmListLiveData;
    private LiveData<List<RawDataResponseDTO.Table>> rawDataFromServerList;
    private LiveData<List<LandholdingCategoryTable>> landholdingCategoryTableListLiveData;


    @Inject
    public AppViewModel(AppRepository appRepository) {
        this.appRepository = appRepository;
    }

    public void getAppsFromServer(String staffId, String mobileNumber) {
        try {
            appStoreResponseDTOLiveData = appRepository.getAppsFromServer(staffId, mobileNumber);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void apkDownloadServiceCall(AppStoreResponseDTO.AppStore appStore, ProgressBar progressBar, String staffId, String mobileNumber) {
        try {
            stringLiveData = appRepository.apkDownloadServiceCall(appStore, progressBar, staffId, mobileNumber);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void getBearerToken(BearerTokenRequestDTO bearerTokenRequestDTO) {
        try {
            bearerTokenResponseDTOLiveData = appRepository.getBearerToken(bearerTokenRequestDTO);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void logInService(String userId, String password, String appVersion) {
        try {
            loginnewResponseDTOLiveData = appRepository.logInService(userId,password,appVersion);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void generateOTP( OTPTriggerDTO otpTriggerDTO,OTPVerificationTable otpVerificationTable){
        try{
            otpTriggerResponseDTOLiveData=appRepository.generateOTP(otpTriggerDTO,otpVerificationTable);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void postSubmittedDataForLead(SubmitDataTable submitDataTables, String screenNumber, LeadTable leadTable, int isSync) {
        try {
            // TODO: Condition need to check
            leadTableLiveData = appRepository.postSubmittedDataForLead(submitDataTables, screenNumber, leadTable,isSync);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void syncAllScreenByClient(MasterTable masterTable){
        try{
            masterTableLiveData=appRepository.syncAllScreenByClient(masterTable);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public void syncAllScreenByClientForFI(FIMasterTable fiMasterTable){
        try{
            fiMasterTableLiveData =appRepository.syncAllScreenByClientForFI(fiMasterTable);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void updateMasterTableStatus(MasterTable masterTable, String finalStatus){
        try{
            masterTableLiveData=appRepository.updateMasterTableStatusNew(masterTable,finalStatus);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void updateFIMasterTableStatus(FIMasterTable fiMasterTable, String finalStatus){
        try{
            fiMasterTableLiveData = appRepository.updateFIMasterTableStatusNew(fiMasterTable,finalStatus);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void panValidationServiceCall(String clientId, String userId, String value){
        try{
            panValidationResponseDTOLiveData=appRepository.panValidationServiceCall(clientId,userId,value);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public void pincodeValidationServiceCall(String clientId, String userId, String value){
        try{
            pincodeResponseDTOLiveData = appRepository.pincodeValidationServiceCall(clientId,userId,value);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public void aadhaarValutServiceCall(String clientId, String userId, String value){
        try{
            aadhaarVaultResponseDTOLiveData = appRepository.aadhaarVaultServiceCall(clientId,userId,value);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void ekycServiceCall(String clientId, String userId, String value){
        try{
            ekycResponseDTOLiveData = appRepository.ekycServiceCall(clientId,userId,value);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void insertDataInlandholdingCategoryTable(LandholdingCategoryTable landholdingCategoryTable) {
        try {
            landholdingCategoryTableListLiveData = appRepository.insertDataInlandholdingCategoryTable(landholdingCategoryTable);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void generateOTPFromServer(OTPTriggerDTO otpTriggerDTO) {
        try {
            otpTriggerResponseDTOLiveData = appRepository.generateOTPFromServer(otpTriggerDTO);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void logOutService(String userId) {
        try {
            logOutResponseDTOLiveData = appRepository.logOutService(userId);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void insertLog(String methodName, String message, String staffId, String screenNo, String screenName, String clientId,
                          String loanType, String moduleType) {
        try {
            //    dynamicUIRepository.insertLog(methodName,message,staffId,screenNo,screenName,clientId,loanType,moduleType);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void insertNewCapturedImageInTable(DocumentUploadTableNew documentUploadTableNewImage){
        try{
            documentUploadLiveDataList=appRepository.insertNewCapturedImageInTable(documentUploadTableNewImage);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void removeCapturedImageFromTable(DocumentUploadTableNew documentUploadTableNewImage){
        try{
            documentUploadLiveDataList=appRepository.removeCapturedImageFromTable(documentUploadTableNewImage);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void getDocumentByDocumentName(DocumentUploadTableNew documentUploadTableNewImage){
        try{
            documentUploadLiveDataList=appRepository.getDocumentByDocumentName(documentUploadTableNewImage);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void getDocumentUploadHeader(String clientId, String loanType, boolean isHeader){
        try{
            stringListLiveData=appRepository.getDocumentUploadHeader(clientId,loanType,isHeader);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void uploadDocumentsToServer(DocumentUploadTableNew documentUploadTableNew){
        try{
            documentUploadLiveDataList=appRepository.uploadDocumentsToServer(documentUploadTableNew);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void getDocumentUploadSubHeader(String clientId, String loanType, boolean isHeader){
        try{
            documentUploadLiveDataList=appRepository.getDocumentUploadSubHeader(clientId,loanType,isHeader);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void getDocumentMasterFromServer(String productId, String projectId){
        try{
            documentMasterListLiveData=appRepository.getDocumentMasterFromServer(productId,projectId);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void verifyOTP(OTPVerifyDTO otpVerifyDTO, OTPVerificationTable otpVerificationTable){
        try{
            otpVerifyResponseDTOLiveData=appRepository.verifyOTP(otpVerifyDTO,otpVerificationTable);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void insertOrUpdateLeadData(LeadTable leadTable, RawDataTable rawdata) {
        try {
            leadTableLiveData = appRepository.insertOrUpdateLeadData(leadTable, rawdata);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void getLeadDataFromLocalDB(String userId, String clientId) {
        try {
            leadTableLiveData = appRepository.getLeadDataFromLocalDB(userId, clientId);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void insertOrUpdateProductDetailsData(RawDataTable rawdata) {
        try {
            rawDataTableLiveData = appRepository.insertOrUpdateProductDetailsData(rawdata);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void insertOrUpdateRawData(RawDataTable rawdata) {
        try {
            rawDataTableLiveData = appRepository.insertOrUpdateProductDetailsData(rawdata);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void autoPopulateScreenDetails(String client_id, String screen_id, String module_type) {
        try {
            rawDataTableLiveData = appRepository.autoPopulateScreenDetails(client_id, screen_id, module_type);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void getLeadData(String screenNo, String userId, String loanType) {
        try {
            leadTableLiveDataList = appRepository.getLeadData(screenNo, userId, loanType);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void getBRETableListFromDB(String clientId, String loanType){
        try{
            cibilTableLiveDataList=appRepository.getBRETableListFromDB(clientId,loanType);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public void getRAMPTableListFromDB(String clientId, String loanType){
        try{
            rampTableLiveDataList=appRepository.getRAMPTableListFromDB(clientId,loanType);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public void getDedupuTableListFromDB(String clientId, String loanType){
        try{
            dedupuTableLiveDataList = appRepository.getDedupuTableListFromDB(clientId,loanType);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

 public void getLegalTableListFromDB(String clientId, String loanType){
        try{
            legalTableLiveDataList = appRepository.getLegalTableListFromDB(clientId,loanType);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void getFCUTableListFromDB(String clientId, String loanType){
        try{
            fcuTableLiveDataList = appRepository.getFCUTableListFromDB(clientId,loanType);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void checkKYCAndPersonalDetailForCIBIL(String clientId, String loanType){
        try{
            cibilTableLiveDataList=appRepository.checkKYCAndPersonalDetailForCIBIL(clientId,loanType);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }


    public void checkKYCAndPersonalDetailForRAMP(String clientId, String loanType){
        try{
            rampTableLiveDataList=appRepository.checkKYCAndPersonalDetailForRAMP(clientId,loanType);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void checkKYCAndPersonalDetailForLegal(String clientId, String loanType){
        try{
            legalTableLiveDataList = appRepository.checkKYCAndPersonalDetailForLegal(clientId,loanType);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public void checkKYCAndPersonalDetailForDedupu(String clientId, String loanType){
        try{
            dedupuTableLiveDataList=appRepository.checkKYCAndPersonalDetailForDedupu(clientId,loanType);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public void checkKYCAndPersonalDetailForFcu(String clientId, String loanType){
        try{
            fcuTableLiveDataList=appRepository.checkKYCAndPersonalDetailForFcu(clientId,loanType);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void generateBREServiceCall(BRETable BRETable, String staffId ){
        try{
            stringLiveData=appRepository.generateBREServiceCall(BRETable,staffId);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public void generateRAMPServiceCall(RAMPTable rampTable, String staffId ){
        try{
            stringLiveData=appRepository.generateRAMPServiceCall(rampTable,staffId);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public void generateLegalServiceCall(LegalTable legalTable, String staffId ){
        try{
            stringLiveData = appRepository.generateLegalServiceCall(legalTable,staffId);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void generateFCUServiceCall(FCUTable fcuTable, String staffId ){
        try{
            stringLiveData = appRepository.generateFCUServiceCall(fcuTable,staffId);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public void generateDEDUPUServiceCall(DEDUPUTable dedupuTable, String staffId ){
        try{
            stringLiveData = appRepository.generateDedupuServiceCall(dedupuTable,staffId);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void getProductDetailsFromLocalDB(String userId, String clientid, String screenno) {
        try {
            rawDataTableLiveData = appRepository.getProductDetailsFromLocalDB(userId, clientid, screenno);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void getRawDataTableListFromLocalDB(String clientId, String screenNo , String moduleType) {
        try {
            rawDataTableLiveDataList = appRepository.getRawDataTableListFromLocalDB(clientId, screenNo, moduleType);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void getSchemeCodesFromLocalDB(String productid) {
        try {
            stringListLiveData = appRepository.getSchemeCodesFromLocalDB(productid);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void getModelFromLocalDB(String productid, String Makeid) {
        try {
            stringListLiveData = appRepository.getModelFromLocalDB(productid, Makeid);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void getNDLPFromLocalDB(String productid, String Makeid) {
        try {
            stringLiveData = appRepository.getNDLPFromLocalDB(productid, Makeid);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void getNDLPFromLocalDB(String productid, String Makeid, String Model) {
        try {
            stringLiveData = appRepository.getNDLPFromLocalDB(productid, Makeid, Model);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void getRSPMFromLocalDB(String state, String Makeid, String Model, String year) {
        try {
            stringLiveData = appRepository.getRSPMFromLocalDB(state, Makeid, Model,year);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void getYearsFromLocalDB(String state, String Makeid, String Model) {
        try {
            stringListLiveData = appRepository.getYearsFromLocalDB(state, Makeid, Model);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void getApplicantDetailsfromLoaclDB(String clientid, String screenno, String screenname) {
        try {

            rawTableLiveData = appRepository.getApplicantDetailsfromLoaclDB(clientid, screenno, screenname);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void getApplicantAdderessDetailsfromLoaclDB(String clientid, String screenno, String screenname) {
        try {

            stringLiveData = appRepository.getApplicantAdderessDetailsfromLoaclDB(clientid, screenno, screenname);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void getOTPVerificationData(String clientId, String loanType){
        try{
            otpVerificationLiveData=appRepository.getOTPVerificationData(clientId,loanType);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void getProductMasterFromServer() {
        try {
            stringListLiveData = appRepository.getProductMasterFromServer();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void getRmListMasterFromServer(String userId, String branchId) {
        try {
            rmListLiveData = appRepository.getRmListFromServer(userId,branchId);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void getProductMasterMakeModelFromServer(String producttype) {
        try {
            stringListLiveData = appRepository.getProductMasterMakeModelFromServer(producttype);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void getProductMasterMakeModelFromServerBasedOnState(String state) {
        try {
            stringListLiveData = appRepository.getProductMasterMakeModelFromServerBasedOnState(state);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void getUsedTractorStatesFromServer() {
        try {
            stringListLiveData = appRepository.getUsedTractorStatesFromServer();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void getRawDataForSingleClient(List<String> screenNameList, String clientId, String loanType, String moduleType) {
        try {
            rawTableLiveData = appRepository.getRawDataForSingleClient(screenNameList, clientId, loanType, moduleType);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void getMasterTableByUserIdAndLoanType(String userId, String loanType) {
        try {
            masterTableLiveDataList = appRepository.getMasterTableByUserIdAndLoanType(userId, loanType);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void getFIMasterTableByUserIdAndLoanType(String userId, String loanType) {
        try {
            fiMasterTableLiveDataList = appRepository.getFIMasterTableByUserIdAndLoanType(userId, loanType);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void getRawDataForCoApplicantSection(List<String> screenNameList, List<String> screenNoList, String clientId,
                                                String loanType, String moduleType, Context context,
                                                ClientDetailsAdapter.ClientDetailsInterface clientDetailsInterface) {
        try {
            clientDetailsAdapterList = appRepository.getRawDataForCoApplicantSection(screenNameList, screenNoList, clientId, loanType, moduleType, context,
                    clientDetailsInterface);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    public void getAppKycDetailsFromLocalDB(String client_id, String screen_id, String module_type){
        try{
            rawDataTableLiveDataList =appRepository.getAppKycDetailsFromLocalDB(client_id,screen_id,module_type);

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void getNoOfCoApplicants(String screenName, String clientId, String userId,
                                    String loanType, String fieldTag) {
        try {
            numberOfCoApplicantLiveData = appRepository.getNoOfCoApplicants(screenName, clientId, userId, loanType, fieldTag);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void getDocumentRawData(String clientId, String staffId, String loanType, String connectionString) {
        try {
            documentUploadRawDataResponseList = appRepository.getDocumentRawData(clientId, staffId, loanType, connectionString);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void getRawDataFromServerForSingleCustomerApplication(String clientId, String userId, String loanType, String productId, String connectionString) {
        try {
            rawDataFromServerList = appRepository.getRawDataFromServerForSingleCustomerApplication(clientId, userId, loanType, productId, connectionString);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void getMasterTableByClientId(String clientId) {
        try {
            masterTableLiveData = appRepository.getMasterTableByClientId(clientId);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public LiveData<LeadTable> getLeadTableLiveData() {
        return leadTableLiveData;
    }

    public LiveData<List<DocumentUploadTableNew>> getDocumentUploadLiveDataList() {
        return documentUploadLiveDataList;
    }

    public LiveData<RawDataTable> getRawDataTableLiveData() {
        return rawDataTableLiveData;
    }
    public LiveData<List<RawDataTable>> getDataTableLiveDataList() {
        return rawDataTableLiveDataList;
    }

    public LiveData<PanValidationResponseDTO> getPanValidationResponseDTOLiveData() {
        return panValidationResponseDTOLiveData;
    }

    public LiveData<PincodeResponseDTO> getPincodeResponseDTOLiveData() {
        return pincodeResponseDTOLiveData;
    }

    public LiveData<List<BRETable>> getCibilTableLiveDataList() {
        return cibilTableLiveDataList;
    }

    public LiveData<List<RAMPTable>> getRAMPTableLiveDataList() {
        return rampTableLiveDataList;
    }
    public LiveData<List<DEDUPUTable>> getDedupuTableLiveDataList() {
        return dedupuTableLiveDataList;
    }
    public LiveData<List<FCUTable>> getFcuTableLiveDataList() {
        return fcuTableLiveDataList;
    }
    public LiveData<List<LegalTable>> getLegalTableLiveDataList() {
        return legalTableLiveDataList;
    }


    public LiveData<List<LandholdingCategoryTable>> getLandholdingCategoryTableListLiveData() {
        return landholdingCategoryTableListLiveData;
    }

    public LiveData<List<LeadTable>> getLeadTableLiveDataList() {
        return leadTableLiveDataList;
    }

    public LiveData<List<MasterTable>> getmasterTableLiveDataList() {
        return masterTableLiveDataList;
    }

    public LiveData<List<FIMasterTable>> getFIMasterTableLiveDataList() {
        return fiMasterTableLiveDataList;
    }

    public LiveData<LoginResponseDTO> getLoginResponseDTOLiveData() {
        return loginResponseDTOLiveData;
    }
    public LiveData<LoginResDTO> getLoginNewResponseDTOLiveData() {
        return loginNewResponseDTOLiveData;
    }

    public LiveData<List<RawDataResponseDTO.Table>> getRawDataFromServerList() {
        return rawDataFromServerList;
    }

    public LiveData<List<RawDataTable>> getRawTableLiveData() {

        return rawTableLiveData;
    }

    public LiveData<List<DocumentUploadRawdataResponseDTO>> getDocumentUploadRawDataResponseList() {
        return documentUploadRawDataResponseList;
    }

    public LiveData<List<ClientDetailsAdapter>> getClientDetailsAdapterList() {
        return clientDetailsAdapterList;
    }

    public LiveData<OTPTriggerResponseDTO> getOtpTriggerResponseDTOLiveData() {
        return otpTriggerResponseDTOLiveData;
    }

    public LiveData<OTPVerifyResponseDTO> getOtpVerifyResponseDTOLiveData() {
        return otpVerifyResponseDTOLiveData;
    }

    public LiveData<List<OTPVerificationTable>> getOTPVerificationLiveData() {
        return otpVerificationLiveData;
    }

    public LiveData<AppStoreResponseDTO> getAppStoreResponseDTOLiveData() {
        return appStoreResponseDTOLiveData;
    }

    public LiveData<NumberOfCoApplicant> getNumberOfCoApplicantLiveData() {
        return numberOfCoApplicantLiveData;
    }

    public LiveData<MasterTable> getmasterTableLiveData() {

        return masterTableLiveData;
    }
    public LiveData<FIMasterTable> getFiMasterTableLiveData() {

        return fiMasterTableLiveData;
    }

    public LiveData<List<String>> getProductMasterTableLiveDataList() {
        return stringListLiveData;
    }
    public LiveData<RmLeads> getRmLiveDataList() {
        return rmListLiveData;
    }

    public LiveData<List<DocumentMasterTable>> getDocumentMasterListLiveData() {
        return documentMasterListLiveData;
    }

    public LiveData<List<String>> getProductMasterMakeModelTableLiveDataList() {
        return stringListLiveData;
    }

    public LiveData<String> getStringLiveData() {

        return stringLiveData;
    }
    public LiveData<List<String>> getStringListLiveData() {

        return stringListLiveData;
    }

    public LiveData<BearerTokenResponseDTO> getBearerTokenResponseDTOLiveData() {
        return bearerTokenResponseDTOLiveData;
    }
    public LiveData<LoginnewResponseDTO> getLoginnewResponseDTOLiveData() {
        return loginnewResponseDTOLiveData;
    }

    public LiveData<LogOutResponseDTO> getLogOutResponseDTOLiveData() {
        return logOutResponseDTOLiveData;
    }

    public LiveData<List<RawDataTable>> getRawDataTableLiveDataList() {
        return rawDataTableLiveDataList;
    }
    public void getCategoryLandholdings(String clientId) {
        try {
            landholdingCategoryTableListLiveData = appRepository.getCategoryLandholdings(clientId);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void getApplicantNamesfromLocalDB(String clientid, String scno) {
        try {
            stringLiveData = appRepository.getApplicantNamesfromLocalDB(clientid,scno);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void verifydatacategorydata(String clientid, String category, String ownername) {
        try {
            stringLiveData = appRepository.verifydatacategorydata(clientid,category,ownername);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void getCoApplicantNamesfromLocalDB(String clientid, String scno) {
        try {
            stringListLiveData = appRepository.getCoApplicantNamesfromLocalDB(clientid,scno);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public LiveData<AadhaarVaultResponseDTO> getAadhaarVaultResponseDTOLiveData() {
        return aadhaarVaultResponseDTOLiveData;
    }

    public LiveData<EKYCResponseDTO> getEkycResponseDTOLiveData() {
        return ekycResponseDTOLiveData;
    }
}
