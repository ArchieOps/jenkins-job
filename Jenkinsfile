def gv

pipeline {
    agent any
    stages {
      
        stage("build") {
            steps {
                script {
                    echo "building the aplication in $BRANCH_NAME"
                    //gv.buildJar()
                }
            }
        }
        stage("build image") {
            when{
                expression{
                    BRANCH_NAME == 'master'
                }
            }
            steps {
                script {
                    echo "building the image for the application->>> $BRANCH_NAME"
                    //gv.buildImage()
                }
            }
        }
        stage("deploy") {
              when{
                expression{
                    BRANCH_NAME == 'master'
                }
            }

            steps {
                script {
                    echo "deploying the application->>> $BRANCH_NAME"
                    //gv.deployApp()
                }
            }
        }
    }   
}
