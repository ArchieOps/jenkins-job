#!/usr/bin/env groovy

library identifier: 'jenkins-shared-library@master', retriever: modernSCM(
        [$class: 'GitSCMSource',
         remote: 'https://github.com/ArchieOps/jenkins-shared-library.git',
         credentialsId: 'github-cred'
        ]
)


def gv

pipeline {
    agent any
    tools {
        maven 'maven-build'
    }
    stages {
        stage("init") {
            steps {
                script {
                    gv = load "script.groovy"
                }
            }
        }
        stage("build jar") {
            steps {
                script {
                    buildJar()
                }
            }
        }
        stage("build and push image") {
            steps {
                script {
                    buildImage 'archieops/my-private-repo:jma-3.0'
                    dockerLogin()
                    dockerPush 'archieops/my-private-repo:jma-3.0'
                }
            }
        }
        stage("deploy") {
            steps {
                script {
                    gv.deployApp()
                }
            }
        }
    }
}
