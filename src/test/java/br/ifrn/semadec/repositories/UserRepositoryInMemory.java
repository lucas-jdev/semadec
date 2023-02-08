package br.ifrn.semadec.repositories;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import br.ifrn.semadec.entities.user.User;
import br.ifrn.semadec.entities.user.UserStatus;
import br.ifrn.semadec.exceptions.not_found.UserNotFoundException;

public class UserRepositoryInMemory implements UserRepository {

    Set<User> users;

    public UserRepositoryInMemory() {
        this.users = new HashSet<>();
    }

    @Override
    public List<User> findAll() {
        return this.users.stream().toList();
    }

    @Override
    public List<User> findAll(Sort sort) {
        return this.users.stream().toList();
    }

    @Override
    public List<User> findAllById(Iterable<UUID> ids) {
        return this.users.stream().toList();
    }

    @Override
    public <S extends User> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends User> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends User> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<User> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<UUID> ids) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public User getOne(UUID id) {
        return this.users.stream().filter(u -> u.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public User getById(UUID id) {
        return this.users.stream().filter(u -> u.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public User getReferenceById(UUID id) {
        return this.users.stream().filter(u -> u.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public <S extends User> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends User> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public <S extends User> S save(S entity) {
        entity.setId(UUID.randomUUID());
        return this.users.add(entity) ? entity : null;
    }

    @Override
    public Optional<User> findById(UUID id) {
        return Optional.ofNullable(this.users.stream().filter(u -> u.getId().equals(id)).findFirst().orElse(null));
    }

    @Override
    public boolean existsById(UUID id) {
        return this.users.stream().anyMatch(u -> u.getId().equals(id));
    }

    @Override
    public long count() {
        return this.users.size();
    }

    @Override
    public void deleteById(UUID id) {
        this.users.removeIf(u -> u.getId().equals(id));
    }

    @Override
    public void delete(User entity) {
        this.users.remove(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends UUID> ids) {
        ids.forEach(id -> this.users.removeIf(u -> u.getId().equals(id)));
    }

    @Override
    public void deleteAll(Iterable<? extends User> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends User> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends User> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends User> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends User> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends User, R> R findBy(
            Example<S> example,
            Function<FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public User findByEmail(String email) {
        return this.users
                .stream()
                .filter(u -> _validateEmailOfUser(email, u) && u.getStatus() == UserStatus.ACTIVE)
                .findFirst()
                .orElse(null);
    }

    @Override
    public User findByUsername(String username) {
        return this.users.stream()
                .filter(u -> u.getUsername().equalsIgnoreCase(username) && u.getStatus() == UserStatus.ACTIVE)
                .findAny().orElseThrow(UserNotFoundException::new);
    }

    @Override
    public User findByCpf(String cpf) {
        return this.users
                .stream()
                .filter(u -> u.getCpf().equals(cpf) && u.getStatus() == UserStatus.ACTIVE)
                .findFirst()
                .orElse(null);
    }

    @Override
    public Collection<User> findByFullName(String fullName) {
        return this.users.stream()
                .filter(u -> u.getFullName().contains(fullName) && u.getStatus() == UserStatus.ACTIVE)
                .toList();
    }

    @Override
    public Collection<User> findAllByEmail(String email) {
        return this.users
                .stream()
                .filter(u -> _checkIfUserContainsEmail(u, email) && u.getStatus() == UserStatus.ACTIVE)
                .toList();
    }

    @Override
    public Collection<User> findAllByUsername(String username) {
        return this.users.stream().filter(u -> u.getUsername().equals(username) && u.getStatus() == UserStatus.ACTIVE)
                .toList();
    }

    @Override
    public Collection<User> findAllByCpf(String cpf) {
        return this.users.stream().filter(u -> u.getCpf().contains(cpf) && u.getStatus() == UserStatus.ACTIVE).toList();
    }

    @Override
    public User findByUsernameAndPassword(String username) {
        return this.users.stream().filter(u -> u.getUsername().equals(username) && u.getStatus() == UserStatus.ACTIVE)
                .findFirst().orElse(null);
    }

    @Override
    public User findByAcademicEmail(String academicEmail) {
        return this.users.stream()
                .filter(u -> u.getAcademicEmail().equalsIgnoreCase(academicEmail) && u.getStatus() == UserStatus.ACTIVE)
                .findFirst()
                .orElse(null);
    }

    @Override
    public User findByPersonalEmail(String personalEmail) {
        return this.users.stream()
                .filter(u -> u.getPersonalEmail().equalsIgnoreCase(personalEmail) && u.getStatus() == UserStatus.ACTIVE)
                .findFirst()
                .orElse(null);
    }

    @Override
    public User findByMatriculation(String matriculation) {
        return this.users.stream()
                .filter(u -> u.getMatriculation().equals(matriculation) && u.getStatus() == UserStatus.ACTIVE)
                .findFirst().orElse(null);
    }

    @Override
    public Collection<User> findByStatus(UserStatus status) {
        return this.users.stream().filter(u -> u.getStatus().equals(status)).toList();
    }

    private boolean _validateEmailOfUser(String email, User user) {
        if (_emailIsNotValid(email)) {
            return false;
        }

        return user.getAcademicEmail().equalsIgnoreCase(email)
                || user.getPersonalEmail().equalsIgnoreCase(email);
    }

    private boolean _emailIsNotValid(String... emails) {
        return Arrays.stream(emails).anyMatch(email -> email == null || email.isBlank());
    }

    private boolean _checkIfUserContainsEmail(User user, String email) {
        return user.getAcademicEmail().contains(email)
                || user.getPersonalEmail().contains(email);
    }

}