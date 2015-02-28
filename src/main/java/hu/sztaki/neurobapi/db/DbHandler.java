package hu.sztaki.neurobapi.db;

import hu.sztaki.neurobapi.db.entities.Allowedvalue;
import hu.sztaki.neurobapi.db.entities.Measurement;
import hu.sztaki.neurobapi.db.entities.Patient;
import hu.sztaki.neurobapi.db.entities.Principal;
import hu.sztaki.neurobapi.db.entities.SPSSExportEntity;
import hu.sztaki.neurobapi.db.entities.Variable;
import hu.sztaki.neurobapi.db.entities.Variablegroup;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DbHandler {

    private SqlSessionFactory sqlSessionFactory;
    private final Logger logger = LoggerFactory.getLogger(DbHandler.class);

    public DbHandler() {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        } catch (IOException e) {
            logger.error("Error while loading mybatis configuration", e);
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException ex) {
                    logger.error("Error while closing inputstream", ex);
                }
            }
        }
    }

    public int dateDiff(int meausurementId) {
        int ret;
        try (SqlSession s = sqlSessionFactory.openSession()) {
            DbMapper m = s.getMapper(DbMapper.class);
            ret = m.dateDiff(meausurementId);
        }
        return ret;
    }

    public List<Variable> getRelevantVariables(int day) {
        List<Variable> ret;
        try (SqlSession s = sqlSessionFactory.openSession()) {
            DbMapper m = s.getMapper(DbMapper.class);
            ret = m.getRelevantVariables(day);
        }
        return ret;
    }

    public Measurement getMeasurement(int id) {
        Measurement ret;
        try (SqlSession s = sqlSessionFactory.openSession()) {
            DbMapper m = s.getMapper(DbMapper.class);
            ret = m.getMeasurement(id);
        }
        return ret;
    }

    public int dateDiffPatient(int patientId) {
        int ret;
        try (SqlSession s = sqlSessionFactory.openSession()) {
            DbMapper m = s.getMapper(DbMapper.class);
            ret = m.dateDiffPatient(patientId);
        }
        return ret;
    }

    public Patient getPatient(int patientId) {
        Patient ret;
        try (SqlSession s = sqlSessionFactory.openSession()) {
            DbMapper m = s.getMapper(DbMapper.class);
            ret = m.getPatient(patientId);
        }
        return ret;
    }

    public List<Variable> getRelevantVariablesInGroup(int day, int gid) {
        List<Variable> ret;
        try (SqlSession s = sqlSessionFactory.openSession()) {
            DbMapper m = s.getMapper(DbMapper.class);
            ret = m.getRelevantVariablesInGroup(day, gid);
        }
        return ret;
    }

    public List<Variablegroup> getVariableGroups() {
        List<Variablegroup> ret;
        try (SqlSession s = sqlSessionFactory.openSession()) {
            DbMapper m = s.getMapper(DbMapper.class);
            ret = m.getVariableGroups();
        }
        return ret;
    }

    public int createMeasurement(int type, int patient, int principal, int recordingUser) {
        int ret;
        try (SqlSession s = sqlSessionFactory.openSession()) {
            DbMapper m = s.getMapper(DbMapper.class);
            AutoIncrement retid = new AutoIncrement();
            logger.info("creating measurement. type:" + type + " patient:" + patient + " principal:" + principal + " recordingUser:" + recordingUser);
            m.createMeasurement(type, patient, principal, recordingUser, retid);
            s.commit();
            ret = retid.getId();
        }
        return ret;
    }

    public List<Principal> getPrincipals() {
        List<Principal> ret;
        try (SqlSession s = sqlSessionFactory.openSession()) {
            DbMapper m = s.getMapper(DbMapper.class);
            ret = m.getPrincipals();
        }
        return ret;
    }

    public List<Allowedvalue> getAllowedvalues(int id) {
        List<Allowedvalue> ret;
        try (SqlSession s = sqlSessionFactory.openSession()) {
            DbMapper m = s.getMapper(DbMapper.class);
            ret = m.getAllowedvalues(id);
        }
        return ret;
    }

    public Variable getVariable(int variableId) {
        Variable ret;
        try (SqlSession s = sqlSessionFactory.openSession()) {
            DbMapper m = s.getMapper(DbMapper.class);
            ret = m.getVariable(variableId);
        }
        return ret;        
    }

    public void insertOrUpdateFree(int measurementId, int variableId, String value) {
        try (SqlSession s = sqlSessionFactory.openSession()) {
            DbMapper m = s.getMapper(DbMapper.class);
            logger.info("updating free value. measurement:" + measurementId + " variable:" + variableId + " value:" + value);
            m.insertOrUpdateFree(measurementId,variableId,value);
            s.commit();
        }
    }

    public void insertOrUpdateAllowed(int measurementId, int variableId, int allowedId) {
        try (SqlSession s = sqlSessionFactory.openSession()) {
            DbMapper m = s.getMapper(DbMapper.class);
            logger.info("updating free value. measurement:" + measurementId + " variable:" + variableId + " value:" + allowedId);
            m.insertOrUpdateAllowed(measurementId,variableId,allowedId);
            s.commit();
        }
    }

    public void updateTextualRepresentation(int measurementId, String text) {
        try (SqlSession s = sqlSessionFactory.openSession()) {
            DbMapper m = s.getMapper(DbMapper.class);
            logger.info("updating measurement with text. measurement:" + measurementId + " text:" + text);
            m.updateTextualRepresentation(measurementId,text);
            s.commit();
        }
    }
    
    public List<SPSSExportEntity> selectAllSPSSEntities() {
        List<SPSSExportEntity> ret;
        try (SqlSession s = sqlSessionFactory.openSession()) {
            DbMapper m = s.getMapper(DbMapper.class);
            ret = m.selectAllSPSSEntities();
        }
        
        return ret;
    }

}
