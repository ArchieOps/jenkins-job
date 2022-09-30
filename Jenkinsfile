#!/usr/bin/env groovy

pipeline {
    agent any
    parameters {
        choice(name: 'VERSION', choices: ['1.1.0', '1.2.0', '1.3.0', '1.4.0', '1.5.0'], description: '')
        booleanParam(name: 'executeTests', defaultValue: true, description: '')
    }
    tools {
        maven 'Maven'
    }
    stages {
        stage('build') {
            steps {
                script {
                    echo "Building the application..."
                    sh "mvn install"
                }
            }
        }
        stage('test') {
            steps {
                script {
                    echo "Testing the application..."
                    sh "mvn test"
                }
            }
        }
        stage('deploy') {

            input {
                message "Select the environment to deploy to"
                ok "Done"
                parameters{
                    choice(name: 'ENV', choices: ['dev', 'staging', 'production'], description: '')
                }
                
            }
        
            steps {
                script {
                    echo "Deploying the ${ENV}"
                }
            }
        }
    }
}
