package servlets;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import db.model.StudentGrades;
import db.model.Students;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import services.interfaces.StudentGradesRepository;
import services.interfaces.StudentsRepository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Configuration
public class Config implements WebMvcConfigurer {

    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jacksonCustomizer() {
        return (builder) -> {
            builder.featuresToDisable(
                    SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,
                    SerializationFeature.WRITE_DURATIONS_AS_TIMESTAMPS,
                    DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE,
                    DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES
            );
            builder.featuresToEnable(
                    DeserializationFeature.FAIL_ON_NUMBERS_FOR_ENUMS
            );
        };
    }


    @Bean
    public Module jacksonJavaTimeModule() {
        return new JavaTimeModule();
    }

    @Bean
    public StudentsRepository studentsRepository() {
        return new StudentsRepository() {
            @Override
            public List<Students> findAll(Sort sort) {
                return null;
            }

            @Override
            public Page<Students> findAll(Pageable pageable) {
                return null;
            }

            @Override
            public <S extends Students> S save(S entity) {
                return null;
            }

            @Override
            public <S extends Students> List<S> saveAll(Iterable<S> entities) {
                return null;
            }

            @Override
            public Optional<Students> findById(Long aLong) {
                return Optional.empty();
            }

            @Override
            public boolean existsById(Long aLong) {
                return false;
            }

            @Override
            public List<Students> findAll() {
                return null;
            }

            @Override
            public List<Students> findAllById(Iterable<Long> longs) {
                return null;
            }

            @Override
            public long count() {
                return 0;
            }

            @Override
            public void deleteById(Long aLong) {

            }

            @Override
            public void delete(Students entity) {

            }

            @Override
            public void deleteAllById(Iterable<? extends Long> longs) {

            }

            @Override
            public void deleteAll(Iterable<? extends Students> entities) {

            }

            @Override
            public void deleteAll() {

            }

            @Override
            public void flush() {

            }

            @Override
            public <S extends Students> S saveAndFlush(S entity) {
                return null;
            }

            @Override
            public <S extends Students> List<S> saveAllAndFlush(Iterable<S> entities) {
                return null;
            }

            @Override
            public void deleteAllInBatch(Iterable<Students> entities) {

            }

            @Override
            public void deleteAllByIdInBatch(Iterable<Long> longs) {

            }

            @Override
            public void deleteAllInBatch() {

            }

            @Override
            public Students getOne(Long aLong) {
                return null;
            }

            @Override
            public Students getById(Long aLong) {
                return null;
            }

            @Override
            public Students getReferenceById(Long aLong) {
                return null;
            }

            @Override
            public <S extends Students> Optional<S> findOne(Example<S> example) {
                return Optional.empty();
            }

            @Override
            public <S extends Students> List<S> findAll(Example<S> example) {
                return null;
            }

            @Override
            public <S extends Students> List<S> findAll(Example<S> example, Sort sort) {
                return null;
            }

            @Override
            public <S extends Students> Page<S> findAll(Example<S> example, Pageable pageable) {
                return null;
            }

            @Override
            public <S extends Students> long count(Example<S> example) {
                return 0;
            }

            @Override
            public <S extends Students> boolean exists(Example<S> example) {
                return false;
            }

            @Override
            public <S extends Students, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
                return null;
            }

            @Override
            public List<Students> findByGroupName(int groupName) {
                return null;
            }
        };
    }
    @Bean
    public StudentGradesRepository studentGradesRepository() {
        return new StudentGradesRepository() {
            @Override
            public List<StudentGrades> findByStudentsGroupName(long id) {
                return null;
            }

            @Override
            public List<StudentGrades> findAll(Sort sort) {
                return null;
            }

            @Override
            public Page<StudentGrades> findAll(Pageable pageable) {
                return null;
            }

            @Override
            public <S extends StudentGrades> S save(S entity) {
                return null;
            }

            @Override
            public <S extends StudentGrades> List<S> saveAll(Iterable<S> entities) {
                return null;
            }

            @Override
            public Optional<StudentGrades> findById(Long aLong) {
                return Optional.empty();
            }

            @Override
            public boolean existsById(Long aLong) {
                return false;
            }

            @Override
            public List<StudentGrades> findAll() {
                return null;
            }

            @Override
            public List<StudentGrades> findAllById(Iterable<Long> longs) {
                return null;
            }

            @Override
            public long count() {
                return 0;
            }

            @Override
            public void deleteById(Long aLong) {

            }

            @Override
            public void delete(StudentGrades entity) {

            }

            @Override
            public void deleteAllById(Iterable<? extends Long> longs) {

            }

            @Override
            public void deleteAll(Iterable<? extends StudentGrades> entities) {

            }

            @Override
            public void deleteAll() {

            }

            @Override
            public void flush() {

            }

            @Override
            public <S extends StudentGrades> S saveAndFlush(S entity) {
                return null;
            }

            @Override
            public <S extends StudentGrades> List<S> saveAllAndFlush(Iterable<S> entities) {
                return null;
            }

            @Override
            public void deleteAllInBatch(Iterable<StudentGrades> entities) {

            }

            @Override
            public void deleteAllByIdInBatch(Iterable<Long> longs) {

            }

            @Override
            public void deleteAllInBatch() {

            }

            @Override
            public StudentGrades getOne(Long aLong) {
                return null;
            }

            @Override
            public StudentGrades getById(Long aLong) {
                return null;
            }

            @Override
            public StudentGrades getReferenceById(Long aLong) {
                return null;
            }

            @Override
            public <S extends StudentGrades> Optional<S> findOne(Example<S> example) {
                return Optional.empty();
            }

            @Override
            public <S extends StudentGrades> List<S> findAll(Example<S> example) {
                return null;
            }

            @Override
            public <S extends StudentGrades> List<S> findAll(Example<S> example, Sort sort) {
                return null;
            }

            @Override
            public <S extends StudentGrades> Page<S> findAll(Example<S> example, Pageable pageable) {
                return null;
            }

            @Override
            public <S extends StudentGrades> long count(Example<S> example) {
                return 0;
            }

            @Override
            public <S extends StudentGrades> boolean exists(Example<S> example) {
                return false;
            }

            @Override
            public <S extends StudentGrades, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
                return null;
            }


        };

    }

}