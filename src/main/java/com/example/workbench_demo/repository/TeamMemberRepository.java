package com.example.workbench_demo.repository;

import com.example.workbench_demo.model.TeamMember;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Stream;

public interface TeamMemberRepository extends JpaRepository<TeamMember, Long> {
    Stream<TeamMember> findByEmailInAndEngagement_Id(Collection<String> emails, String id);

    Optional<TeamMember> findByEmailAndEngagement_Id(String email, String id);


}