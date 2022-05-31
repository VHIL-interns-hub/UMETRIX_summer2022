from django.db import models
#from djongo import models

# Create your models here.

#OID = ObjectId() 

class CodeSnippets(models.Model):
    #_id = models.ObjectIdField()
    Snip = models.TextField(blank = True)
    #def __str__(self):
		 #   return self.name
    #blog = models.EmbeddedField(model_container=ReferenceTable)


class ReferenceTable(models.Model):
    CodeSnippetID = models.AutoField(primary_key = True)
    Tag = models.CharField(max_length = 500)
    Description = models.TextField()   # charfield is the smaller version
    OptChar = models.TextField()
    OptInt = models.IntegerField()
    snip = models.ForeignKey(CodeSnippets, null = True, on_delete=models.SET_NULL)
    #Link = OID

   # class Meta:
    #    abstract = True
    



