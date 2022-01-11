apt update
apt upgrade
apt install nginx -y
apt install docker -y
mkdir -p /opt/tour-logger
cat default.conf > /etc/nginx/sites-available/default
systemctl restart nginx
cp docker-compose-prod.yml /opt/tour-logger/docker-compose.yml
echo "DONT FORGET: iptables -I INPUT -p tcp --dport 80 -j ACCEPT"


