package br.ifrn.semadec.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import br.ifrn.semadec.entities.user_provider.UserProvider;

public class UserProviderRepositoryInMemory implements UserProviderRepository {

    private List<UserProvider> userProviders;

    public UserProviderRepositoryInMemory() {
        this.userProviders = new ArrayList<>();
    }

    @Override
    public UserProvider findByUsernameAndToken(String username, String token) {
        return this.userProviders.stream()
                .filter(userProvider -> userProvider.getUsername().equalsIgnoreCase(username))
                .filter(userProvider -> userProvider.getToken().equals(token))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<UserProvider> findAll() {
        return this.userProviders;
    }

    @Override
    public List<UserProvider> findAll(Sort sort) {
        return null;
    }

    @Override
    public List<UserProvider> findAllById(Iterable<UUID> ids) {
        return this.userProviders.stream()
                .filter(userProvider -> ids.equals(userProvider.getId()))
                .toList();
    }

    @Override
    public <S extends UserProvider> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends UserProvider> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends UserProvider> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<UserProvider> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<UUID> ids) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public UserProvider getOne(UUID id) {
        return this.userProviders.stream()
                .filter(userProvider -> userProvider.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public UserProvider getById(UUID id) {
        return this.userProviders.stream()
                .filter(userProvider -> userProvider.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public UserProvider getReferenceById(UUID id) {
        return this.userProviders.stream()
                .filter(userProvider -> userProvider.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public <S extends UserProvider> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends UserProvider> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public Page<UserProvider> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public <S extends UserProvider> S save(S entity) {
        this.userProviders.add(entity);
        return entity;
    }

    @Override
    public Optional<UserProvider> findById(UUID id) {
        return this.userProviders.stream()
                .filter(userProvider -> userProvider.getId().equals(id))
                .findFirst();
    }

    @Override
    public boolean existsById(UUID id) {
        return this.userProviders.stream()
                .filter(userProvider -> userProvider.getId().equals(id))
                .findFirst()
                .isPresent();
    }

    @Override
    public long count() {
        return this.userProviders.size();
    }

    @Override
    public void deleteById(UUID id) {
        this.userProviders.removeIf(userProvider -> userProvider.getId().equals(id));

    }

    @Override
    public void delete(UserProvider entity) {
        this.userProviders.remove(entity);

    }

    @Override
    public void deleteAllById(Iterable<? extends UUID> ids) {
        // TODO Auto-generated method stub

    }

    @Override
    public void deleteAll(Iterable<? extends UserProvider> entities) {
        // TODO Auto-generated method stub

    }

    @Override
    public void deleteAll() {
        // TODO Auto-generated method stub

    }

    @Override
    public <S extends UserProvider> Optional<S> findOne(Example<S> example) {
        // TODO Auto-generated method stub
        return Optional.empty();
    }

    @Override
    public <S extends UserProvider> Page<S> findAll(Example<S> example, Pageable pageable) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <S extends UserProvider> long count(Example<S> example) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public <S extends UserProvider> boolean exists(Example<S> example) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public <S extends UserProvider, R> R findBy(Example<S> example,
            Function<FetchableFluentQuery<S>, R> queryFunction) {
        // TODO Auto-generated method stub
        return null;
    }

}
