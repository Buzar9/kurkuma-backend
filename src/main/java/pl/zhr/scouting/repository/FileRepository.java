package pl.zhr.scouting.repository;

import pl.zhr.scouting.entity.File;

import java.util.List;

public interface FileRepository {

    List<File> findAll();

    File findById(int fileId);

    void saveOrUpdate(File theFile);

    void delete(int fileId);
}
