package hu.sztaki.neurobapi.db;

import hu.sztaki.neurobapi.db.entities.Allowedvalue;
import hu.sztaki.neurobapi.db.entities.Measurement;
import hu.sztaki.neurobapi.db.entities.Patient;
import hu.sztaki.neurobapi.db.entities.Principal;
import hu.sztaki.neurobapi.db.entities.SPSSExportEntity;
import hu.sztaki.neurobapi.db.entities.Variable;
import hu.sztaki.neurobapi.db.entities.Variablegroup;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 *
 * @author Mihály Héder <mihaly.heder@sztaki.mta.hu>
 */
public interface DbMapper {

    @Select("SELECT DATEDIFF(measurement.date,patient.birthDate) FROM patient,measurement WHERE measurement.id = #{param1} AND patient.id = measurement.patientid")
    int dateDiff(int measurementId);
    
    @Select("SELECT * FROM variable WHERE relevancestart <= #{param1} and relevanceend >= #{param1}")
    List<Variable> getRelevantVariables(int day);
     
    @Select("SELECT * FROM measurement WHERE id = #{param1}")
    Measurement getMeasurement(int id);

    @Select("SELECT DATEDIFF(CURDATE(),patient.birthDate) FROM patient WHERE patient.id = #{param1}")
    public int dateDiffPatient(int patientId);

    @Select("SELECT * FROM patient WHERE id = #{param1}")
    public Patient getPatient(int patientId);

    @Select("SELECT * FROM variable WHERE groupid=#{param2} AND ((relevancestart <= #{param1} AND relevanceend >= #{param1}) OR (relevancestart is NULL AND relevanceend is NULL))")
    public List<Variable> getRelevantVariablesInGroup(int day,int gid);

    @Select("SELECT * FROM variablegroup")
    public List<Variablegroup> getVariableGroups();

    @Options(useGeneratedKeys=true, keyProperty="param5.id")
    @Insert("INSERT INTO measurement (measurementtypeid,patientid,date,time,principalid,recordinguserid) VALUES(#{param1},#{param2},CURDATE(),NOW(),#{param3},#{param4})")
    public int createMeasurement(int type, int patient, int principal, int recordingUser,AutoIncrement ret);
    
    @Select("SELECT * FROM principal")
    public List<Principal> getPrincipals();

    @Select("SELECT * FROM allowedvalue WHERE variableid = #{param1}")
    public List<Allowedvalue> getAllowedvalues(int id);

    @Select("SELECT * FROM variable WHERE id = #{param1}")
    public Variable getVariable(int variableId);

    @Insert("INSERT INTO datapoint (measurementid,variableid,freevalue) VALUES (#{param1},#{param2},#{param3}) ON DUPLICATE KEY UPDATE freevalue = #{param3}")
    public void insertOrUpdateFree(int measurementId, int variableId, String value);
 
    @Insert("INSERT INTO datapoint (measurementid,variableid,valueid) VALUES (#{param1},#{param2},#{param3}) ON DUPLICATE KEY UPDATE valueid = #{param3}")
    public void insertOrUpdateAllowed(int measurementId, int variableId, int allowedId);

    @Update("UPDATE measurement SET textualrepresentation=#{param2} WHERE id=#{param1}")
    public void updateTextualRepresentation(int measurementId, String text);
    
    @Select("SELECT * FROM view_for_spss_export")
    public List<SPSSExportEntity> selectAllSPSSEntities();
}
