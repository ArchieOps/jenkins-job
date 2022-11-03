pipeline {
	agent any
	tools{
		maven 'maven'
	}
	stages {
		stage("build jar"){
			steps{
				script {
					echo "building the application"
					sh 'mvn package'
				}
			}
		}
		stage("build docker image"){
			steps{
				script {
					echo "building the docker image"
					withCredentials([usernamePassword(credentialsId: 'nexus-docker-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]){
						sh 'docker build -t 10.9.0.4:8083/java-maven-app:1.3  .'
						sh "echo $PASS | docker login -u $USER --password-stdin 10.9.0.4:8083"
						sh 'docker push 10.9.0.4:8083/java-maven-app:1.3'
					}
				}
			}
		}
		stage("deploy"){
			steps{
				script{
					echo "deploying the application"
				}
			}
		}
	}
}
