package ru.esphere.school.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.esphere.school.data.Member;
import ru.esphere.school.data.MembersGroup;

import java.util.*;

class FinderTest {

    Finder finder;
    List<MembersGroup> groups;

    @BeforeEach
    void setup() {
        Member member1 = new Member("Anna", 12);
        Member member2 = new Member("Anna", 25);
        Member member3 = new Member("Kate", 1);
        Member member4 = new Member("John", 0);
        Member member5 = new Member("Ben", -100);
        Member member6 = new Member("Ben", 666);
        Member member7 = new Member("George", 5);
        Member member8 = new Member("Russel", 0);
        Member member9 = new Member("Susan", 22);

        List<Member> list1 = new ArrayList<Member>() {{
            add(member1);
            add(member2);
            add(member3);
        }};

        List<Member> list2 = new ArrayList<>();

        List<Member> list3 = new ArrayList<Member>() {{
            add(member4);
            add(member5);
            add(member6);
            add(member7);
            add(member8);
        }};

        List<Member> list4 = new ArrayList<Member>() {{
            add(member9);
        }};

        MembersGroup membersGroup1 = new MembersGroup("MembersGroup1", list1);
        MembersGroup membersGroup2 = new MembersGroup("MembersGroup2", list2);
        MembersGroup membersGroup3 = new MembersGroup("MembersGroup3", list3);
        MembersGroup membersGroup4 = new MembersGroup("MembersGroup4", list4);

        groups = new ArrayList<MembersGroup>() {{
            add(membersGroup1);
            add(membersGroup2);
            add(membersGroup3);
            add(membersGroup4);
        }};

        finder = new Finder();
    }

    @Test
    void findOldMembersOlderThan10() {
        Set<String> expected = new HashSet<String>() {{
            add("Anna");
            add("Ben");
            add("Susan");
        }};
        Set<String> result = finder.findOldMembers(groups, 10);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void findOldMembersOlderThan100() {
        Set<String> expected = new HashSet<String>() {{
            add("Ben");
        }};
        Set<String> result = finder.findOldMembers(groups, 100);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void findOldMembersOlderThan1000() {
        Set<String> expected = new HashSet<>();
        Set<String> result = finder.findOldMembers(groups, 1000);
        Assertions.assertEquals(expected, result);
    }
}