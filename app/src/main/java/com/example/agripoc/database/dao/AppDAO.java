package com.example.agripoc.database.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;

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
import com.rblfinserve.rvf.database.entity.ProductMasterMakeModelTable;
import com.rblfinserve.rvf.database.entity.ProductMasterMakeModelUsedTable;
import com.rblfinserve.rvf.database.entity.ProductMasterTable;
import com.rblfinserve.rvf.database.entity.RAMPTable;
import com.rblfinserve.rvf.database.entity.RawDataTable;
import com.rblfinserve.rvf.database.entity.SubmitDataTable;

import java.util.List;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public abstract class AppDAO {

    @Insert(onConflict = REPLACE)
    public abstract void insertLeadTable(LeadTable leadTable);

    @Insert(onConflict = REPLACE)
    public abstract void insertRawData(RawDataTable rawDataTable);

    @Insert(onConflict = REPLACE)
    public abstract void insertCIBILTable(BRETable BRETable);

    @Insert(onConflict = REPLACE)
    public abstract void insertRAMPTable(RAMPTable rampTable);

    @Insert(onConflict = REPLACE)
    public abstract void insertLegalTable(LegalTable legalTable);

    @Insert(onConflict = REPLACE)
    public abstract void insertDEDUPUTable(DEDUPUTable dedupuTable);

    @Insert(onConflict = REPLACE)
    public abstract void insertFCUTable(FCUTable fcuTable);

    @Insert(onConflict = REPLACE)
    public abstract void insertLandHoldingCategory(LandholdingCategoryTable landholdingCategoryTable);

    @Insert(onConflict = REPLACE)
    public abstract void insertMasterTable(MasterTable masterTable);

    @Insert(onConflict = REPLACE)
    public abstract void insertFIMasterTable(FIMasterTable fiMasterTable);

    @Insert(onConflict = REPLACE)
    public abstract void insertOTPVerification(OTPVerificationTable otpVerificationTable);

    @Insert(onConflict = REPLACE)
    public abstract void insertDocumentUploadNew(DocumentUploadTableNew documentUploadTableNew);


    @Insert(onConflict = REPLACE)
    public abstract void saveProductMasterTable(List<ProductMasterTable> productMasterTableList);

    @Insert(onConflict = REPLACE)
    public abstract void saveDocumentMasterTable(List<DocumentMasterTable> documentMasterTableList);

    @Insert(onConflict = REPLACE)
    public abstract void saveProductMasterMakeModelTable(List<ProductMasterMakeModelTable> productMasterMakeModelTableList);

    @Insert(onConflict = REPLACE)
    public abstract void saveProductMasterMakeModelUsedTable(List<ProductMasterMakeModelUsedTable> productMasterMakeModelTableList);

    @Insert(onConflict = REPLACE)
    public abstract void insertSubmitTableDataList(List<SubmitDataTable> submitDataTableList);

    @Query("DELETE FROM LeadTable WHERE clientId = :clientId ")
    public abstract void deleteLeadTable(String clientId);

    @Query("DELETE FROM SubmitDataTable WHERE ApplicationId = :clientId ")
    public abstract void deleteSubmitDataTable(String clientId);

    @Query("SELECT * FROM DocumentMasterTable ")
    public abstract List<DocumentMasterTable> getDocumentMasterTable();

    @Query("Update BRETable set isCBChecked=:isCBChecked , name=:name , mobileNumber=:mobileNumber  where id=:id")
    public abstract void updateCIBILTableMobileAndName(int id , String mobileNumber, String name, boolean isCBChecked);

    @Query("Update RAMPTable set isRampChecked=:isRAMPChecked , name=:name , mobileNumber=:mobileNumber  where id=:id")
    public abstract void updateRAMPTableMobileAndName(int id , String mobileNumber, String name, boolean isRAMPChecked);

    @Query("Update LegalTable set isLegalChecked=:isLegalChecked , name=:name , mobileNumber=:mobileNumber  where id=:id")
    public abstract void updateLegalTableMobileAndName(int id , String mobileNumber, String name, boolean isLegalChecked);

    @Query("Update DEDUPUTable set isDedupuChecked=:isDEDUPUChecked , name=:name , mobileNumber=:mobileNumber  where id=:id")
    public abstract void updateDEDUPUTableMobileAndName(int id , String mobileNumber, String name, boolean isDEDUPUChecked);

    @Query("Update RAMPTable set isRampChecked=:isRAMPChecked  where id=:id")
    public abstract void updateRAMPTableStatus(int id , boolean isRAMPChecked);

    @Query("Update FCUTable set isFcuChecked=:isFcuChecked  where id=:id")
    public abstract void updateFCUTableStatus(int id , boolean isFcuChecked);

    @Query("Update LegalTable set isLegalChecked=:isLegalChecked  where id=:id")
    public abstract void updateLegalTableStatus(int id , boolean isLegalChecked);

    @Query("Update BRETable set isCBChecked=:isCBChecked  where id=:id")
    public abstract void updateBRETableStatus(int id , boolean isCBChecked);

    @Query("Update DEDUPUTable set isDedupuChecked=:isDEDUPUChecked  where id=:id")
    public abstract void updateDEDUPUTableStatus(int id , boolean isDEDUPUChecked);

    @Query("SELECT * FROM BRETable where moduleType=:moduleType and client_id=:clientId")
    public abstract BRETable getCIBILTableByModuleType(String clientId, String moduleType);

    @Query("SELECT * FROM RAMPTable where moduleType=:moduleType and client_id=:clientId")
    public abstract RAMPTable getRAMPTableByModuleType(String clientId, String moduleType);


    @Query("SELECT * FROM LegalTable where moduleType=:moduleType and client_id=:clientId")
    public abstract LegalTable getLegalTableByModuleType(String clientId, String moduleType);

    @Query("SELECT * FROM DEDUPUTable where moduleType=:moduleType and client_id=:clientId")
    public abstract DEDUPUTable getDEDUPUTableByModuleType(String clientId, String moduleType);


    @Query("SELECT * FROM FCUTable where moduleType=:moduleType and client_id=:clientId")
    public abstract FCUTable getFCUableByModuleType(String clientId, String moduleType);

    @Query("SELECT * FROM BRETable where moduleType=:moduleType and client_id=:clientId")
    public abstract BRETable getBRETableByModuleType(String clientId, String moduleType);

    @Query("SELECT * FROM RawDataTable where screen_name=:screenName and client_id=:clientId and moduleType=:moduleType Order by id desc limit 1")
    public abstract RawDataTable getRawDataByClientAndModuleTypeTopOne(String screenName, String clientId, String moduleType);

    @Query("Update BRETable set isCBChecked=:isCBChecked , Decision=:decision , " +
            "score=:score,Reason=:reason,ApplicationId=:applicationId,SolutionSetInstanceId=:solutionSetInstanceId , " +
            " timestamp=:timestamp where client_id=:clientId and moduleType=:moduleTye")

    public abstract void updateBRETableDataFromServer(String clientId , String moduleTye, String decision, String score, String reason, String applicationId,
                                                      String solutionSetInstanceId, String timestamp , boolean isCBChecked);

 @Query("Update RAMPTable set isRampChecked=:isRampChecked , Decision=:decision , " +
            "score=:score,Reason=:reason,ApplicationId=:applicationId,SolutionSetInstanceId=:solutionSetInstanceId , " +
            " timestamp=:timestamp where client_id=:clientId and moduleType=:moduleTye")
    public abstract void updateRampTableDataFromServer(String clientId , String moduleTye, String decision, String score, String reason, String applicationId,
                                                       String solutionSetInstanceId, String timestamp , boolean isRampChecked);

 @Query("Update LegalTable set isLegalChecked=:isLegalChecked , Decision=:decision , " +
            "score=:score,Reason=:reason,ApplicationId=:applicationId,SolutionSetInstanceId=:solutionSetInstanceId , " +
            " timestamp=:timestamp where client_id=:clientId and moduleType=:moduleTye")
    public abstract void updateLegalTableDataFromServer(String clientId , String moduleTye, String decision, String score, String reason, String applicationId,
                                                        String solutionSetInstanceId, String timestamp , boolean isLegalChecked);

 @Query("Update FCUTable set isFcuChecked=:isFcuChecked , Decision=:decision , " +
            "score=:score,Reason=:reason,ApplicationId=:applicationId,SolutionSetInstanceId=:solutionSetInstanceId , " +
            " timestamp=:timestamp where client_id=:clientId and moduleType=:moduleTye")
    public abstract void updateFCUTableDataFromServer(String clientId , String moduleTye, String decision, String score, String reason, String applicationId,
                                                      String solutionSetInstanceId, String timestamp , boolean isFcuChecked);

 @Query("Update DEDUPUTable set isDedupuChecked=:isRampChecked , Decision=:decision , " +
            "score=:score,Reason=:reason,ApplicationId=:applicationId,SolutionSetInstanceId=:solutionSetInstanceId , " +
            " timestamp=:timestamp where client_id=:clientId and moduleType=:moduleTye")
    public abstract void updateDedupuTableDataFromServer(String clientId , String moduleTye, String decision, String score, String reason, String applicationId,
                                                         String solutionSetInstanceId, String timestamp , boolean isRampChecked);


    @Query("SELECT * FROM OTPVerificationTable where moduleType=:moduleType and client_id=:clientId ")
    public abstract OTPVerificationTable getOTPVerificationByModuleType(String clientId, String moduleType);

    @Query("SELECT * FROM RAMPTable where moduleType=:moduleType and client_id=:clientId ")
    public abstract RAMPTable getRampVerificationByModuleType(String clientId, String moduleType);


    @Query("SELECT * FROM RawDataTable where screen_name=:screenName and client_id=:clientId and moduleType=:moduleType and loan_type=:loanTye")
    public abstract List<RawDataTable> getRawDataByScreenNameAndModuleType(String screenName, String clientId, String moduleType, String loanTye);

    @Query("SELECT * FROM RawDataTable where client_id=:clientID and screen_name IN (:screenList)")
    public abstract List<RawDataTable> getRawDataByClientAndScreenNameList(List<String> screenList, String clientID);

    @Query("select *  from LeadTable where clientId=:clientId and createdBy=:userId ORDER BY id DESC LIMIT 1")
    public abstract LeadTable getTopLeadData(String userId, String clientId);

    @Query("select *  from RawDataTable where client_id=:clientId and screen_no=:screenno ORDER BY id DESC LIMIT 1")
    public abstract RawDataTable getRawDataByClientId(String clientId, String screenno);

    @Query("SELECT * FROM MasterTable WHERE id = :id")
    public abstract MasterTable getMasterTableDetailById(int id);

    @Query("SELECT * FROM FIMasterTable WHERE id = :id")
    public abstract FIMasterTable getFIMasterTableDetailById(int id);

//    @Query("SELECT * FROM LogInTable where UserID=:userId ")
//    public abstract LogInTable getLoginTable(String userId);

    @Query("select *  from RawDataTable where client_id=:clientId and screen_no=:screenNo" +
            " and moduleType=:moduleType ORDER BY id DESC ")
    public abstract List<RawDataTable> getRawDataTableListFromLocalDB(String clientId, String screenNo, String moduleType);


    @Query("select *  from RawDataTable where client_id=:clientId and screen_no=:screenno and multiple_data =:multiple_data ORDER BY id DESC")
    public abstract RawDataTable getRawDataByClientIdAndMultipleData(String clientId, String screenno, String multiple_data);


    @Query("select *  from LandholdingCategoryTable where ClientId=:clientId ORDER BY id DESC LIMIT 3")
    public abstract List<LandholdingCategoryTable> getLandholdingCategorybyClientId(String clientId);

    @Query("SELECT distinct rawdata FROM RawDataTable  where client_id=:clientId and screen_no=:screenno ORDER BY id DESC LIMIT 1")
    public abstract String getApplicantNamesfromLocalDB(String clientId, String screenno);

    @Query("SELECT  distinct Landholding_In_Acres FROM LandholdingCategoryTable  where ClientId=:clientId and Category=:category and OwnerName=:ownerName  ORDER BY id DESC ")
    public abstract String verifydatacategorydata(String clientId, String category, String ownerName);

    @Query("SELECT distinct rawdata FROM RawDataTable  where client_id=:clientId and screen_no=:screenno ORDER BY id DESC ")
    public abstract List<String> getCoApplicantNamesfromLocalDB(String clientId, String screenno);

    @Query("select *  from RawDataTable where client_id=:clientId and screen_no=:screenNo" +
            " and moduleType=:moduleType ORDER BY id DESC LIMIT 1")
    public abstract RawDataTable getRawDataByClientIdAndModuleType(String clientId, String screenNo, String moduleType);


    @Query("SELECT * FROM BRETable where client_id=:clientId and loan_type=:loanType")
    public abstract List<BRETable> getBRETableList(String clientId, String loanType);

    @Query("SELECT * FROM RAMPTable where client_id=:clientId and loan_type=:loanType")
    public abstract List<RAMPTable> getRAMPTableList(String clientId, String loanType);

    @Query("SELECT * FROM LegalTable where client_id=:clientId and loan_type=:loanType")
    public abstract List<LegalTable> getLegalTableList(String clientId, String loanType);

    @Query("SELECT * FROM DEDUPUTable where client_id=:clientId and loan_type=:loanType")
    public abstract List<DEDUPUTable> getDEDUPUTableList(String clientId, String loanType);

    @Query("SELECT * FROM FCUTable where client_id=:clientId and loan_type=:loanType")
    public abstract List<FCUTable> getFCUTableList(String clientId, String loanType);

    @Query("select *  from RawDataTable where user_id=:userid and client_id=:clientId and screen_no=:screenno ORDER BY id DESC LIMIT 1")
    public abstract RawDataTable getRawDataByClientId(String userid, String clientId, String screenno);

    @Query("select *  from RawDataTable where user_id=:userid and client_id=:clientId and screen_no=:screenno ORDER BY id DESC LIMIT 1")
    public abstract List<RawDataTable> getReferenceDetailsFromLocalDB(String userid, String clientId, String screenno);

    @Query("SELECT * FROM LeadTable where createdBy=:userId  order by id desc LIMIT 300")
    public abstract List<LeadTable> getLeadTableListFromDBTop300(String userId);


    @Query("select *  from RawDataTable where client_id=:clientId and screen_no=:screenNo" +
            " and moduleType=:moduleType ORDER BY id DESC ")
    public abstract List<RawDataTable> getAppKycDetailsFromLocalDB(String clientId, String screenNo, String moduleType);

    @Query("update LeadTable set sync=:status where clientId=:clientId")
    public abstract void updateLeadSyncStatus(String clientId, boolean status);

    @Query("SELECT * FROM MasterTable where createdBy = :userId  order by id desc limit 300")
    public abstract List<MasterTable> getMasterTableByUserIdAndLoanTypeByTop300(String userId);

    @Query("SELECT * FROM FIMasterTable where createdBy = :userId  order by id desc limit 300")
    public abstract List<FIMasterTable> getFIMasterTableByUserIdAndLoanTypeByTop300(String userId);

    @Query("SELECT * FROM MasterTable WHERE clientId = :clientId")
    public abstract MasterTable getMasterTableByClientId(String clientId);

    @Query("SELECT * FROM FIMasterTable WHERE clientId = :clientId")
    public abstract FIMasterTable getFIMasterTableByClientId(String clientId);

    @Query("DELETE FROM ProductMasterTable  ")
    public abstract void deleteProductMasterTable();

    @Query("DELETE FROM DocumentMasterTable  ")
    public abstract void deleteDocumentMasterTable();

    @Query("DELETE FROM ProductMasterMakeModelTable  ")
    public abstract void deleteProductMasterMakeModelTable();

    @Query("DELETE FROM ProductMasterMakeModelUsedTable  ")
    public abstract void deleteProductMasterMakeModelUsedTable();

    @Query("SELECT distinct clientId FROM MasterTable where reviewBy = :userId and loan_type=:loanType")
    public abstract List<String> getClientsFromMasterTable(String userId, String loanType);

    @Query("SELECT distinct Product_Type FROM ProductMasterTable ")
    public abstract List<String> getDistntProducts();

    @Query("SELECT distinct Tractor_Make FROM ProductMasterMakeModelTable ")
    public abstract List<String> getDistntProductsMakeModel();

    @Query("SELECT distinct Make FROM ProductMasterMakeModelUsedTable ")
    public abstract List<String> getDistntProductsMakeModelUsed();

    @Query("SELECT distinct Scheme_Code FROM ProductMasterTable where Product_Type = :producttype")
    public abstract List<String> getDistntSchemecodes(String producttype);

    @Query("SELECT distinct Model FROM ProductMasterMakeModelTable where Product_Type = :producttype and Tractor_Make=:maketype")
    public abstract List<String> getDistntModelFromLocalDB(String producttype, String maketype);

    @Query("SELECT distinct Model FROM ProductMasterMakeModelUsedTable where Make = :maketype")
    public abstract List<String> getDistntModelUsedFromLocalDB(String maketype);

    @Query("SELECT distinct NDLP_Amount FROM ProductMasterMakeModelTable where Product_Type = :producttype and Tractor_Make=:maketype")
    public abstract String getNDLPFromLocalDB(String producttype, String maketype);

    @Query("SELECT distinct NDLP_Amount FROM ProductMasterMakeModelTable where Product_Type = :producttype and Tractor_Make=:maketype and Model=:model")
    public abstract String getNDLPFromLocalDB(String producttype, String maketype, String model);

    @Query("SELECT distinct NDLP FROM ProductMasterMakeModelUsedTable where State = :state and Make=:maketype and Model=:model and Year=:year")
    public abstract String getRSPMFromLocalDB(String state, String maketype, String model, String year);

    @Query("SELECT distinct Year FROM ProductMasterMakeModelUsedTable where State = :State and Make=:maketype and Model=:model")
    public abstract List<String> getDistntYearsUsedFromLocalDB(String State, String maketype, String model);


    @Query("SELECT * FROM RawDataTable where client_id = :clientid and screen_no=:screenno and screen_name=:screenname")
    public abstract List<RawDataTable> getApplicantDetailsfromLoaclDB(String clientid, String screenno, String screenname);

    @Query("SELECT distinct rawdata FROM RawDataTable  where client_id=:clientid and screen_no=:screenno and screen_name=:screenname ORDER BY id DESC ")
    public abstract String getApplicantAdderessDetailsfromLoaclDB(String clientid, String screenno, String screenname);

    @Query("SELECT * FROM OTPVerificationTable where client_id=:clientId and loan_type=:loanType")
    public abstract List<OTPVerificationTable> loadOTPVerificationData(String clientId, String loanType);



    @Query("SELECT * FROM RawDataTable where screen_name IN (:screenNameList) and client_id=:clientId and loan_type=:loanType and moduleType=:moduleType")
    public abstract List<RawDataTable> getRawDataForSingleClient(List<String> screenNameList, String clientId, String loanType, String moduleType);

    @Query("SELECT DISTINCT moduleType from  RawDataTable where client_id=:clientId and loan_type=:loanType" +
            " and moduleType LIKE '%' || :moduleType || '%'")
    public abstract List<String> getNoOfCoApplicants(String clientId, String loanType, String moduleType);

    @Query("select distinct moduleType from RawDataTable where client_id=:clientId and screen_name=:screenName " +
            "and user_id=:userId and loan_type=:loanType ")
    public abstract List<String> getNoOfCoApplicants(String screenName, String clientId, String userId, String loanType);

    @Query("select *  from RawDataTable where screen_name=:screenName and client_id=:clientId and loan_type=:loanType ORDER BY id DESC LIMIT 1")
    public abstract RawDataTable getRawDataByScreenNameAndLoanType(String screenName, String clientId, String loanType);

    @Query("SELECT * FROM RawDataTable where screen_no=:screenNo and client_id=:clientId ")
    public abstract List<RawDataTable> getRawDataByScreenNoAndClientId(String screenNo, String clientId);

    @Query("SELECT * FROM RawDataTable where screen_name=:fromScreenName and client_id=:clientID and moduleType=:moduleType")
    public abstract List<RawDataTable> getRawDataByClientAndScreenNameModuleTye(String fromScreenName, String clientID, String moduleType);

    @Query("SELECT DISTINCT screen_no from  RawDataTable where client_id=:clientId and moduleType=:moduleType")
    public abstract List<String> getDistinctScreenNumbers(String clientId, String moduleType);

    @Query("Update RawDataTable set rawdata=:rawdatabag , sync=0 where screen_no=:screenNo and id=:id")
    public abstract void updateRawDataBag(String screenNo, int id, String rawdatabag);

    @Query("Update MasterTable set sync=:sync  where id=:id")
    public abstract void updateMasterTableSync(boolean sync, int id);

    @Query("Update FIMasterTable set sync=:sync  where id=:id")
    public abstract void updateFIMasterTableSync(boolean sync, int id);

    @Query("Update MasterTable set response=:response  where clientId=:clientId and loan_type=:loanType")
    public abstract void updateMasterTableResponse(String response, String clientId, String loanType);


    @Query("Update FIMasterTable set response=:response  where clientId=:clientId and loan_type=:loanType")
    public abstract void updateFIMasterTableResponse(String response, String clientId, String loanType);

    @Query("Update MasterTable set AllDataCaptured=:isAllDataCaptured ,response=:message where id=:id")
    public abstract void updateMasterTableAllDataCaptured(boolean isAllDataCaptured, String message, int id);

    @Query("Update FIMasterTable set AllDataCaptured=:isAllDataCaptured ,response=:message where id=:id")
    public abstract void updateFIMasterTableAllDataCaptured(boolean isAllDataCaptured, String message, int id);

    @Query("Update MasterTable set FinalStatus=:finalStatus,Remarks=:remarks  where id=:id")
    public abstract void updateMasterTableStatus(String finalStatus, String remarks, int id);

    @Query("Update FIMasterTable set FinalStatus=:finalStatus,Remarks=:remarks  where id=:id")
    public abstract void updatFIMasterTableStatus(String finalStatus, String remarks, int id);

    @Query("Update OTPVerificationTable set isOTPVerified=:isOtpVerified  where id=:id and mobileNumber=:mobileNumber")
    public abstract void updateOTPVerified(int id , String mobileNumber, boolean isOtpVerified);

    @Query("Update OTPVerificationTable set isOTPVerified=0 , isOTPGenerated=:isOTPGenerated ,RefferenceId=:refId where id=:id and mobileNumber=:mobileNumber")
    public abstract void updateOTPGenerated(int id , String mobileNumber, boolean isOTPGenerated, String refId);

    @Query("UPDATE DocumentUploadTableNew set ResponseMessage=:response, document_status=:status" +
            " WHERE client_id=:clientId and loan_type = :loanType " +
            " and isHeader=:isHeader and document_name=:documentName and module_type =:moduleType")
    public abstract void updateDocumentResponseAndStatus(String response, boolean status, String clientId, String loanType, boolean isHeader,
                                                         String documentName, String moduleType);

    @Query("UPDATE DocumentUploadTableNew set ResponseMessage=:response, document_status=:status" +
            " WHERE id=:id ")
    public abstract void updateDocumentResponseAndStatusByID(String response, boolean status, int id);

    @Query("UPDATE DocumentUploadTableNew set file_name=:fileName, file_path=:filePath" +
            " WHERE id=:id ")
    public abstract void updateDocumentFileNameAndFilePathByID(String fileName, String filePath, int id);

    @Query("Update OTPVerificationTable set name=:fullname,mobileNumber=:mobile  where id=:id")
    public abstract void updateOTPVerificationTableFullNameAndMobile(int id , String fullname, String mobile);

    @Query("Update BRETable set name=:fullname,mobileNumber=:mobile  where id=:id")
    public abstract void updateCibilFullNameAndMobile(int id , String fullname, String mobile);

    @Query("Update RAMPTable set name=:fullname,mobileNumber=:mobile  where id=:id")
    public abstract void updateRampFullNameAndMobile(int id , String fullname, String mobile);


    @Query("Update LegalTable set name=:fullname,mobileNumber=:mobile  where id=:id")
    public abstract void updateLegalFullNameAndMobile(int id , String fullname, String mobile);

    @Query("Update DEDUPUTable set name=:fullname,mobileNumber=:mobile  where id=:id")
    public abstract void updateDedupuFullNameAndMobile(int id , String fullname, String mobile);

    @Query("Update FCUTable set name=:fullname,mobileNumber=:mobile  where id=:id")
    public abstract void updateFCUFullNameAndMobile(int id , String fullname, String mobile);

    @Query("SELECT DISTINCT file_name FROM DocumentUploadTableNew where client_id=:clientId and loan_type=:loanType and isHeader=:isHeader and " +
            "document_name=:documentName and module_type=:moduleType and document_status=:status")
    public abstract List<String> getUploadedDocumentByDocumentName(String clientId, String loanType, boolean isHeader,
                                                                   String documentName,
                                                                   String moduleType, boolean status);

    @Query("SELECT * FROM RawDataTable where screen_no=:screenNo and client_id=:clientId and loan_type=:loanType  Order by id desc limit 1")
    public abstract RawDataTable getRawDataByScreenNoTopOne(String screenNo, String clientId, String loanType);

    @Query("SELECT * FROM DocumentUploadTableNew where client_id=:clientId and loan_type=:loanType and isHeader=:isHeader")
    public abstract List<DocumentUploadTableNew> getDocumentUploadSubHeader(String clientId, String loanType, boolean isHeader);

    @Query("SELECT * FROM DocumentUploadTableNew where client_id=:clientId and loan_type=:loanType and isHeader=:isHeader" +
            " and document_status=:status and file_path is not null ")
    public abstract List<DocumentUploadTableNew> getUnUploadedDocuments(String clientId, String loanType, boolean isHeader, boolean status);

    @Query("SELECT * FROM OTPVerificationTable where moduleType=:moduleType and client_id=:clientId and screen_name=:screenName")
    public abstract OTPVerificationTable getOTPVerificationByModuleTypeAndScreenName(String clientId, String moduleType, String screenName);

    @Query("SELECT * FROM BRETable where moduleType=:moduleType and client_id=:clientId and screen_name=:screenName")
    public abstract BRETable getCibilByModuleTypeAndScreenName(String clientId, String moduleType, String screenName);

    @Query("SELECT * FROM RAMPTable where moduleType=:moduleType and client_id=:clientId and screen_name=:screenName")
    public abstract RAMPTable getRampByModuleTypeAndScreenName(String clientId, String moduleType, String screenName);

    @Query("SELECT * FROM DEDUPUTable where moduleType=:moduleType and client_id=:clientId and screen_name=:screenName")
    public abstract DEDUPUTable getDedupuByModuleTypeAndScreenName(String clientId, String moduleType, String screenName);

    @Query("SELECT * FROM LegalTable where moduleType=:moduleType and client_id=:clientId and screen_name=:screenName")
    public abstract LegalTable getLegalByModuleTypeAndScreenName(String clientId, String moduleType, String screenName);

    @Query("SELECT * FROM FCUTable where moduleType=:moduleType and client_id=:clientId and screen_name=:screenName")
    public abstract FCUTable getFcuByModuleTypeAndScreenName(String clientId, String moduleType, String screenName);

    @Query("SELECT DISTINCT moduleType from  RawDataTable where client_id=:clientId  and moduleType != 'Lead' " +
            "and moduleType != 'ColdCalling'and moduleType != 'SalesTool'")
    public abstract List<String> getDistinctModuleType(String clientId);

    @Query("SELECT * FROM RawDataTable where screen_name=:fromScreenName and client_id=:clientID")
    public abstract List<RawDataTable> getRawDataByClientAndScreenName(String fromScreenName, String clientID);

    @Query("SELECT * FROM DocumentUploadTableNew where client_id=:clientId and loan_type=:loanType and isHeader=:isHeader and " +
            "document_name=:documentName and module_type=:moduleType")
    public abstract List<DocumentUploadTableNew> getDocumentListByDocumentName(String clientId, String loanType, boolean isHeader, String documentName,
                                                                               String moduleType);

    @Query("SELECT distinct module_type FROM DocumentUploadTableNew where client_id=:clientId and loan_type=:loanType and isHeader=:isHeader")
    public abstract List<String> getDocumentUploadHeader(String clientId, String loanType, boolean isHeader);

    @Query("SELECT * from  DocumentMasterTable where ScreenId=:screenId and FileFormat=:fileFormat")
    public abstract DocumentMasterTable getDocumentMasterByScreenAndFileFormat(String screenId, String fileFormat);

    @Query("SELECT * from  DocumentMasterTable where ScreenId=:screenId and DocumentName=:documentName and DisplayName=:displayName and CustomerType=:customerType")
    public abstract DocumentMasterTable getDocumentMasterByScreenAndDisplayName(String screenId, String documentName, String displayName, String customerType);

    @Query("SELECT * from  DocumentMasterTable where ScreenId=:screenId and DocumentName=:documentName and CustomerType=:customerType")
    public abstract DocumentMasterTable getDocumentMasterByScreenAndDocumentName(String screenId, String documentName, String customerType);

    @Query("SELECT * FROM DocumentUploadTableNew where file_format=:fileFormat and client_id=:clientId and module_type=:moduleType and isHeader=:isHeader")
    public abstract DocumentUploadTableNew getDocumentHeaderByFileFormatAndModuleType(String fileFormat, String clientId, String moduleType, boolean isHeader);

    @Query("DELETE FROM DocumentUploadTableNew WHERE id=:id ")
    public abstract void deleteDocumentFromTable(int id);

    @Query("SELECT * from  OTPVerificationTable where client_id=:clientId and loan_type=:loanType")
    public abstract List<OTPVerificationTable> getOTPTableList(String clientId, String loanType);


    @Transaction
    public void deleteAndInsertLeadTable(LeadTable leadTable) {
        // Anything inside this method runs in a single transaction.
        deleteLeadTable(leadTable.getClientId());
        insertLeadTable(leadTable);
    }

    @Transaction
    public void insertAndDeleteProductMasterTable(List<ProductMasterTable> productMasterTableList) {
        // Anything inside this method runs in a single transaction.
        deleteProductMasterTable();
        saveProductMasterTable(productMasterTableList);
    }
    @Transaction
    public void insertAndDeleteDocumentMasterTable(List<DocumentMasterTable> documentMasterTableList) {
        // Anything inside this method runs in a single transaction.
        deleteDocumentMasterTable();
        saveDocumentMasterTable(documentMasterTableList);
    }
    @Transaction
    public void insertAndDeleteProductMasterMakeModelTable(List<ProductMasterMakeModelTable> productMasterMakeModelTableList) {
        // Anything inside this method runs in a single transaction.
//        deleteProductMasterMakeModelTable();
        saveProductMasterMakeModelTable(productMasterMakeModelTableList);
    }
    @Transaction
    public void insertAndDeleteProductMasterMakeModelUsedTable(List<ProductMasterMakeModelUsedTable> productMasterMakeModelUsedTableList) {
        // Anything inside this method runs in a single transaction.
//        deleteProductMasterMakeModelTable();
        saveProductMasterMakeModelUsedTable(productMasterMakeModelUsedTableList);
    }

    @Transaction
    public void insertAndDeleteSubmitDataTable(List<SubmitDataTable> submitDataTableList, String clientId) {
        // Anything inside this method runs in a single transaction.
        deleteSubmitDataTable(clientId);
        insertSubmitTableDataList(submitDataTableList);
    }
}
