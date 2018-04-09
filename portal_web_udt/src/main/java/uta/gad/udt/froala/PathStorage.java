package uta.gad.udt.froala;

public enum PathStorage  {
    FOLDER_STORAGE("/home/patricio/Programas/STS-3.6.4/sts-bundle/pivotal-tc-server-developer-3.1.0.RELEASE/base-instance/wtpwebapps/portal_web_udt/WEB-INF/uploads/");
///home/patricio/Documents/worksapce-sts-3.6.4/portal_web_udt/src/main/webapp/WEB-INF/uploads
    private String url;

    PathStorage(String url) {
        this.url = url;
    }

    public String url() {
        return url;
    }
}
