Lengte <- c(1.72, 1.59, 1.66, 1.96, 1.80, 1.85, 1.96, 1.75, 1.78, 1.61, 1.66, 1.67, 1.86, 1.65, 1.74, 1.89, 1.81, 1.83, 1.96, 1.95)


Gemiddelde_Lengte <- mean(Lengte)
Standaarddeviatie_Lengte <- sd(Lengte)
h<-hist(Lengte, breaks=10, col="red", xlab="==> Student lengte (m)", 
  	main="Histogram met de normaal verdeling") 
xfit<-seq(min(Lengte),max(Lengte),length=40) 
yfit<-dnorm(xfit,mean=Gemiddelde_Lengte,sd=Standaarddeviatie_Lengte) 
yfit <- yfit*diff(h$mids[1:2])*length(Lengte) 
lines(xfit, yfit, col="blue", lwd=2)






# Add a Normal Curve (Thanks to Peter Dalgaard)
x <- mtcars$mpg 
h<-hist(x, breaks=10, col="red", xlab="Miles Per Gallon", 
  	main="Histogram with Normal Curve") 
xfit<-seq(min(x),max(x),length=40) 
yfit<-dnorm(xfit,mean=mean(x),sd=sd(x)) 
yfit <- yfit*diff(h$mids[1:2])*length(x) 
lines(xfit, yfit, col="blue", lwd=2)