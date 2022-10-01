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
        stage('build jar') {
            steps {
                script {
                    echo "Building the application jar file..."
                    sh 'mvn package'
                }
            }
        }
        stage('build docker image') {
            steps {
                script {
                    echo "Building the docker image..."
                    withCredentials([usernamePassword(credentialsId: 'DockerHub-Credentials', passwordVariable: 'PASS', usernameVariable: 'USER')]){
                        sh 'docker build -t akintunero/devops_bootcamp:JMA-1.0 .'
                        sh "echo $PASS | docker login -u $USER --password-stdin"
                        'docker push akintunero/devops_bootcamp:JMA-1.0'
                    }
                }
            }
        }
        stage('deploy') {

            input {
                message "Select the environment to deploy to"
                ok "Done"
                parameters{
                    choice(name: 'FIRST_ENV', choices: ['dev', 'staging', 'production'], description: '')
                    choice(name: 'SECOND_ENV', choices: ['dev', 'staging', 'production'], description: '')
                }
                
            }
        
            steps {
                script {
                    echo "Deploying the ${FIRST_ENV}"
                    echo "Deploying the ${SECOND_ENV}"
                }
            }
        }
    }
}
