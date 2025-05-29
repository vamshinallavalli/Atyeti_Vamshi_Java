package com.atyeti.service;

import com.atyeti.model.*;

public class ConversionService{
    public static void doRename(Root root){

        if(root.getDepartments()!=null){
            for(DepartmentsItem dept:root.getDepartments()){
                dept.setName("Marvel Series");

                if(dept.getTeams()!=null){
                    for(TeamsItem team:dept.getTeams()){
                        team.setName("DC Series");


                        if(team.getMembers()!=null){
                            for(MembersItem member:team.getMembers()){
                                member.setName("Games Of Thrones");
                            }
                        }
                    }
                }

            }


        }

        if(root.getProjects()!=null){
            for(ProjectsItem project:root.getProjects()){
                project.setName("Avartar Series");
            }
        }
    }
}