def gv

pipeline {
    agent any
    stages {
      
        stage("build") {
            steps {
                script {
                    
                    echo "building the application..."
                    sh 'mvn package'
                    //gv.buildJar()
                }
            }
        }
        stage("build image") {
         
            steps {
                script {
                   
                    echo "building the docker image..."
                    withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
                    sh 'docker build -t kokismoki/new-deploy:jma-2.0 .'
                    sh "echo $PASS | docker login -u $USER --password-stdin"
                    sh 'docker push kokismoki/new-deploy:jma-2.0'
    }
                    //gv.buildImage()
                }
            }
        }
        stage("deploy") {
            

            steps {
                script {
                    echo "deploying the application->>> $BRANCH_NAME"
                    //gv.deployApp()
                }
            }
        }
    }   
}
