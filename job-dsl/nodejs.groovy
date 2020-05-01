job('NodeJS example') {
    scm {
        git('https://github.com/jaamey/devopsJenkins/tree/master/job-dsl') {  node -> // is hudson.plugins.git.GitSCM
            node / gitConfigName('jaamey')
            node / gitConfigEmail('jaamey@gmail.com')
        }
    }
    triggers {
        scm('H/5 * * * *')
    }
    wrappers {
        nodejs('nodejs') // this is the name of the NodeJS installation in 
                         // Manage Jenkins -> Configure Tools -> NodeJS Installations -> Name
    }
    steps {
        shell("npm install")
    }
}
