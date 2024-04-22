def buildJar() {
    echo "building the application..."
    sh 'mvn package'
} 

def buildImage() {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'dockerhub-cred', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t archieops/my-private-repo:jma-2.0 .'
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh 'docker push archieops/my-private-repo:jma-2.0'
    }
} 

def testApp() {
    echo "testing app right now..."
}

def buildApp(){
    echo "building app right now..."
}

def deployApp() {
    echo 'deploying the application...'
} 

return this
