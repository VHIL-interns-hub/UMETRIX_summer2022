from rest_framework import serializers
from snippetsApp.models import CodeSnippets, ReferenceTable

class CodeSnippetsSerializer(serializers.ModelSerializer):
    class Meta:
        model = CodeSnippets
        fields=('Snip')

class ReferenceTableSerializer(serializers.ModelSerializer):
    class Meta:
        model = ReferenceTable
        fields=('CodeSnippetID','Tag','Description','OptChar','OptInt') # add snip here