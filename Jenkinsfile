#!/usr/bin/env groovy

pipeline {
    agent any
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
            steps {
                script {
                    echo "Deploying the application..."
                }
            }
        }
    }
}
