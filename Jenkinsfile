def gv
pipeline {
    agent any
    tools {
        maven 'Maven'
    }
    stages {
        stage('init'){
            steps{
                script{
                    gv = load "script.groovy"
                } 
            }
        }
        stage("build jar"){
            steps {
                script {
                    gv.buildJar()
                }
            }
        }
        stage("build image"){
            steps {
                script {
                    gv.buildApp()
                }
            }
        }
        stage("deploy"){
            steps{
                script {
                    gv.deployApp()
                }
            }
        }
    }
}

