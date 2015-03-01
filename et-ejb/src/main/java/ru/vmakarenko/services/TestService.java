package ru.vmakarenko.services;

import ru.vmakarenko.entities.Test;

import javax.xml.registry.infomodel.User;
import java.util.List;
import java.util.UUID;

/**
 * Created by VMakarenko on 2/4/15.
 */
public interface TestService {

    Test getById(Long id);

    Test update(Test Test);

    Test create(Test Test);

    void delete(Long id);
}
