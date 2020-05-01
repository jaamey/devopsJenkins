job('NodeJS Docker example') {
    scm {
        git('https://github.com/jaamey/devopsJenkins') {  node -> // is hudson.plugins.git.GitSCM
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
        dockerBuildAndPublish {
            repositoryName('ameyjocker/docker-nodejs-demo')
            tag('${GIT_REVISION,length=9}')
            registryCredentials('dockeHubCred')
            forcePull(false)
            forceTag(false)
            createFingerprints(false)
            skipDecorate()
        }
    }
}
