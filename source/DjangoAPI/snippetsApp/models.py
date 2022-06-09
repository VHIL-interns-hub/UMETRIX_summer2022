from django.db import models
#from djongo import models

# Create your models here.

#OID = ObjectId() 

class CodeSnippets(models.Model):
    #_id = models.ObjectIdField()
    Snip = models.TextField(blank = True)
    def __str__(self):
		   return self.name
    #blog = models.EmbeddedField(model_container=ReferenceTable)


class ReferenceTable(models.Model):
    CodeSnippetID = models.AutoField(primary_key = True)
    #Tag = models.CharField(max_length = 500)
    Tag = models.TextField()
    Description = models.TextField()   # charfield is the smaller version
    Code = models.TextField()
    OptChar = models.TextField()
    OptInt = models.IntegerField()
    #snip = models.ForeignKey(CodeSnippets, null = True, on_delete=models.CASCADE, related_name = "snippets")
    #Code = models.TextField()
    #Link = OID

   # class Meta:
    #    abstract = True
    



