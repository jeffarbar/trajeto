docker build -t jeffersonfarias/trajeto:latest  -f Dockerfile .
docker login --username=jeffersonfarias
docker push jeffersonfarias/trajeto:latest
