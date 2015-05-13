mvn clean package -DskipTests=true
git add .
git commit -m "$@"
git push heroku master
heroku ps:scale web=2
sleep 10
heroku logs

