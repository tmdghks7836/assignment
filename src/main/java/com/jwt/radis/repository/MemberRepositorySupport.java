package com.jwt.radis.repository;

import com.jwt.radis.model.entity.SupplyBook;
import com.jwt.radis.model.entity.QMember;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MemberRepositorySupport extends QuerydslRepositorySupport {

    private final JPAQueryFactory queryFactory;

    private final QMember qMember = QMember.member;

    public MemberRepositorySupport(JPAQueryFactory queryFactory){
        super(SupplyBook.class);
        this.queryFactory = queryFactory;

    }

    public void save(SupplyBook supplyBook) {
        getEntityManager().persist(supplyBook);
    }

    public Optional<SupplyBook> findById(Long id) {
        SupplyBook findSupplyBook = getEntityManager().find(SupplyBook.class, id);
        return Optional.ofNullable(findSupplyBook);
    }

    public List<SupplyBook> findAll() {
        return getEntityManager().createQuery("select m from SupplyBook m", SupplyBook.class)
                .getResultList();
    }

//    public List<Member> findAll_Querydsl() {
//        return queryFactory.selectFrom(member)
//                .fetch();
//    }

    public Optional<SupplyBook> findByUsername(String username) {

        SupplyBook supplyBook = queryFactory.selectFrom(qMember)
                .where(qMember.username.eq(username))
                .fetchOne();

        return Optional.ofNullable(supplyBook);
    }

//    public List<Member> findByUsername_Querydsl(String username) {
//        return queryFactory.selectFrom(member)
//                .where(member.username.eq(username))
//                .fetch();
//    }
//
//    public List<MemberTeamDto> searchByBuilder(MemberSearchCondition condition) {
//
//        BooleanBuilder builder = new BooleanBuilder();
//        if (hasText(condition.getUsername())) {
//            builder.and(member.username.eq(condition.getUsername()));
//        }
//
//        if (hasText(condition.getTeamName())) {
//            builder.and(team.name.eq(condition.getTeamName()));
//        }
//
//        if (condition.getAgeGoe() != null) {
//            builder.and(member.age.goe(condition.getAgeGoe()));
//        }
//
//        if (condition.getAgeLoe() != null) {
//            builder.and(member.age.loe(condition.getAgeLoe()));
//        }
//
//
//        return queryFactory
//                .select(new QMemberTeamDto(
//                        member.id.as("memberId"),
//                        member.username,
//                        member.age,
//                        team.id.as("teamId"),
//                        team.name.as("teamName")))
//                .from(member)
//                .leftJoin(member.team, team)
//                .where(builder)
//                .fetch();
//    }
//
//    public List<MemberTeamDto> search(MemberSearchCondition condition) {
//
//        QuerydslRepositorySupport querydslRepositorySupport;
//        return queryFactory
//                .select(new QMemberTeamDto(
//                        member.id.as("memberId"),
//                        member.username,
//                        member.age,
//                        team.id.as("teamId"),
//                        team.name.as("teamName")))
//                .from(member)
//                .leftJoin(member.team, team)
//                .where(usernameEq(condition.getUsername()),
//                        teamNameEq(condition.getTeamName()),
//                        ageGoe(condition.getAgeGoe()),
//                        ageLoe(condition.getAgeLoe()))
//                .fetch();
//    }
//
//    public List<Member> searchMember(MemberSearchCondition condition) {
//        return queryFactory
//                .selectFrom(member)
//                .leftJoin(member.team, team)
//                .where(usernameEq(condition.getUsername()),
//                        teamNameEq(condition.getUsername()),
//                        ageBetween(condition.getAgeGoe(), condition.getAgeGoe()))
//                .fetch();
//    }

    //  private BooleanExpression ageBetween(int ageLoe, int ageGoe) {
//        return ageGoe(ageLoe).and(ageGoe(ageGoe));
//    }

//    private BooleanExpression ageLoe(Integer ageLoe) {
//        return ageLoe != null ? member.age.loe(ageLoe) : null;
//    }
//
//    private BooleanExpression ageGoe(Integer ageGoe) {
//        return ageGoe != null ? member.age.goe(ageGoe) : null;
//    }
//
//    private BooleanExpression teamNameEq(String teamName) {
//        return isEmpty(teamName) ? null : team.name.eq(teamName);
//    }
//
//    private BooleanExpression usernameEq(String username) {
//        return isEmpty(username) ? null : member.username.eq(username);
//    }


}
