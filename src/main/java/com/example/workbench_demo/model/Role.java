package com.example.workbench_demo.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name="role")
public class Role {
	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NonNull
	private String title;

	@ManyToOne
	@JoinColumn(name = "team_member_id")
	private TeamMember member;
}
