package com.example.workbench_demo.repository;

import com.example.workbench_demo.model.TeamMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public interface TeamMemberRepository extends JpaRepository<TeamMember, Long> {
    @Query("select t from TeamMember t where t.email in ?1 and t.engagement.id = ?2")
    Stream<TeamMember> findByEmailsAndEngagementId(Collection<String> emails, String id);


    @Query("select t from TeamMember t where t.email = ?1 and t.engagement.id = ?2")
    Optional<TeamMember> findByEmailAndEngagementId(String email, String id);

    @Query("""
            select t from TeamMember t
            where (upper(t.email) like upper(concat('%', ?1, '%')) or upper(t.name) like upper(concat('%', ?2, '%'))) and t.engagement.id = ?3""")
    List<TeamMember> findByCredentialAndEngagementId(String email, String name, String id);


}