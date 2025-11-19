package ecom.mlslsenarathna.repository;

import ecom.mlslsenarathna.model.entity.AttendenceEntity;
import java.util.List;

public interface AttendenceRepository {
    List<AttendenceEntity> getAllAttendence();

    void setAttendenceOn(AttendenceEntity attendenceEntity);

    AttendenceEntity getLastAttendence();
}
