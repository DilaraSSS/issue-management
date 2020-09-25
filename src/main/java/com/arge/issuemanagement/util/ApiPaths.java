package com.arge.issuemanagement.util;

/**
 * Created by dilara.akbas on Sep, 2020
 */
public final class ApiPaths {

    private static final String BASE_PATH ="/api";

    public static final class IssueCtrl{
        public static final String CTRL = "/issue";
    }

    public static final class ProjectCtrl{
        public static final String CTRL = "/project";
    }

    public static final class Methods{
        public static final String GET_BY_ID = "/getById/";
        public static final String CREATE = "/create";
        public static final String UPDATE = "/update/";
        public static final String DELETE = "/delete/";
        public static final String GET_BY_PROJECT_CODE = "/getByProjectCode/";
    }
}
