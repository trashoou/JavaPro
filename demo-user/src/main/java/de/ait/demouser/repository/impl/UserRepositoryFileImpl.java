package de.ait.demouser.repository.impl;


import de.ait.demouser.model.User;
import de.ait.demouser.repository.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UserRepositoryFileImpl implements UserRepository {

    private final String fileName;

    public UserRepositoryFileImpl(@Value ("${users.file-name}") String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<User> findAll() {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            return br.lines()
                    .map(line -> line.split("#"))
                    .map(parsed -> new User(parsed[0],parsed[1],parsed[2],parsed[3]))
                    .collect(Collectors.toList());
        }catch (IOException e) {
            throw new IllegalStateException("Problem to read from file: "+e.getMessage());
        }
    }

    @Override
    public void save(User user) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true))) {
            bw.write(user.getFirstName() +'#'+ user.getLastName() +'#'+ user.getEmail() +'#'+ user.getPassword());
            bw.newLine();

        } catch (IOException e) {
            throw new IllegalStateException("Problems to write into file: "+e.getMessage());
        }
    }
}
