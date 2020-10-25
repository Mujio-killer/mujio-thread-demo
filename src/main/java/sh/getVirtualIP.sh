######################################################
# HA主备服务
# 1.判断 vip 是否存在
# 2.判断 是否是 主服务
# 返回：
######################################################
result=`ip addr show`
paramip=$1
result2=`echo $result|grep $paramip`
if [[ $result2 != '' ]]
then 
  echo 0
else 
  echo 1
fi
